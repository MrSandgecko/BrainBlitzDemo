package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private Map<String, String> teacherCredentials;
    private Map<String, String> studentCredentials;

    public LoginService() {

        teacherCredentials = new HashMap<>();

        teacherCredentials.put("admin", "admin");
        teacherCredentials.put("Teacher1", "teacher1");
        teacherCredentials.put("Teacher2", "teacher12");

        studentCredentials = new HashMap<>();

        studentCredentials.put("notadmin", "notadmin");
        studentCredentials.put("Student1", "student1");
        studentCredentials.put("Student2", "student2");

    }

    public boolean authenticate(String userName, String password) {

        if (teacherCredentials.containsKey(userName) && teacherCredentials.get(userName).equals(password)) {
            // TeacherMainFrame tMainFrame = new TeacherMainFrame();
            // tMainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            // tMainFrame.pack();
            // tMainFrame.setVisible(true);
            return true;

        } else if (studentCredentials.containsKey(userName) && studentCredentials.get(userName).equals(password)) {
            // StudentMainFrame tMainFrame = new StudentMainFrame();
            // tMainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            // tMainFrame.pack();
            // tMainFrame.setVisible(true);
            return true;
        } else {
            System.out.println("Invalid username or password.");
            return false;
        }

    }

    public String getUserType(String userName) {
        if (teacherCredentials.containsKey(userName)) {
            return "teacher";
        }else if(studentCredentials.containsKey(userName) ){
            return "student";
        }else{
            return null;
        }
    }

}
