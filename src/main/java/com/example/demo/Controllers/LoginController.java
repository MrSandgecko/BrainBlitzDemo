package com.example.demo.Controllers;

import java.util.HashMap;

// import org.hibernate.usertype.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Services.LoginService;

import org.springframework.ui.Model;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showQuiz() {
        return "login";
    }

    @Autowired
    LoginService loginService = new LoginService();

    @PostMapping("/login")
    public String AuthenticateUser(@RequestParam String username, @RequestParam String password, Model model) {

        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            model.addAttribute("Login error", "Invalid username or password. Please enter valid credentials.");
            return "login";
        }

        String userType = loginService.getUserType(username);
        boolean isauthenticated = loginService.authenticate(username, password);

        if ("teacher".equals(userType) && isauthenticated || "admin".equals(userType) && isauthenticated) {
            model.addAttribute("username", username);

            HashMap<String, String> teacherNextPagePathMap = new HashMap<>();
            teacherNextPagePathMap.put("admin", "/teacherMain");
            teacherNextPagePathMap.put("Teacher1", "/teacherMain");
            teacherNextPagePathMap.put("Teacher2", "/teacherMain");

            String nextPagePathType = teacherNextPagePathMap.get(username);

            System.out.println("User Type: " + userType);
            System.out.println("Is Authenticated: " + isauthenticated);
            System.out.println("Next Page Path Type: " + nextPagePathType);

            if (nextPagePathType != null) {
                return "redirect:" + nextPagePathType;
            }
        } else if ("student".equals(userType) && isauthenticated || "notadmin".equals(userType) && isauthenticated) {
            model.addAttribute("username", username);

            HashMap<String, String> studentNextPagePathMap = new HashMap<>();
            studentNextPagePathMap.put("notadmin", "/studentMain");
            studentNextPagePathMap.put("Student1", "/studentMain");
            studentNextPagePathMap.put("Student2", "/studentMain");
            String nextPagePathType = studentNextPagePathMap.get(username);

            System.out.println("User Type: " + userType);
            System.out.println("Is Authenticated: " + isauthenticated);
            System.out.println("Next Page Path Type: " + nextPagePathType);

            if (nextPagePathType != null) {
                return "redirect:" + nextPagePathType;
            }
        }

        model.addAttribute("Login error", "Invalid username or password. lol");
        return "login";
    }
}
