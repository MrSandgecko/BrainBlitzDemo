package com.example.demo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class TeacherMainController {

    @GetMapping("/teacherMain")
    public String showTeacherMainPage() {
        return "teacherMain";
    }
    
}
