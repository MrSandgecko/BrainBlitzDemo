package com.example.demo.Services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private Map<String, String> teacherCredentials;
    private Map<String, String> studentCredentials;

    public LoginService() {
        teacherCredentials = new HashMap<>();
        studentCredentials = new HashMap<>();

        /********************************
         * * Load credentials from the database for teachers
         *******************************/
        LoadCredsFromDB("teachers", teacherCredentials);

        /********************************
         * * Load credentials from the database for students
         *******************************/
        LoadCredsFromDB("students", studentCredentials);
    }

    private void LoadCredsFromDB(String tableName, Map<String, String> credentialsMap) {
        String url = "jdbc:mysql://localhost:3306/new_schema";
        String user = "root";
        String password = "admin1234";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT username, password FROM " + tableName;
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        String username = resultSet.getString("username");
                        String pass = resultSet.getString("password");
                        credentialsMap.put(username, pass);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /********************************
     * * Check if account exists
     *******************************/

    public boolean authenticate(String userName, String password) {
        if (teacherCredentials.containsKey(userName) && teacherCredentials.get(userName).equals(password)) {
            return true;
        } else if (studentCredentials.containsKey(userName) && studentCredentials.get(userName).equals(password)) {
            return true;
        } else {
            System.out.println("Invalid username or password.");
            return false;
        }
    }

      /********************************
         * * Teacher or Student? comes in handy
         *******************************/
    public String getUserType(String userName) {
        if (teacherCredentials.containsKey(userName)) {
            return "teacher";
        } else if (studentCredentials.containsKey(userName)) {
            return "student";
        } else {
            return null;
        }
    }
}
