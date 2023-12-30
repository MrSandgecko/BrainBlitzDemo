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

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/login")
    public String showQuiz() {
        return "login";
    }

    @PostMapping("/login")
    public String AuthenticateUser(@RequestParam String username, @RequestParam String password, Model model) {

        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            
            System.out.println(model.addAttribute("Login error", "Invalid username or password. Please enter valid credentials."));
            return "login";
        }

        String userType = loginService.getUserType(username);

        if (userType != null) {
            if (userType.contains("Teacher")) {
                if(loginService.checkCreds(userType, username, password)){
                return "/teacherMain";
                }else{
                    System.out.println("Invalid username or password. LOL");
                    return "/login";
                }

            } else if (userType.contains("Student")) {
                if(loginService.checkCreds(userType, username, password)){
                return "/studentMain";
                }else{
                    System.out.println("Invalid username or password. LOL");
                    return "/login";
                }
            }
        }
        return "login";
    }
}
