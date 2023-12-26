package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QuizCreationController2 {

    @GetMapping("/quizCreationTab2")
    public String showPage(@RequestParam int questionNumber, Model model) {
        model.addAttribute("questionNumber", questionNumber);

        return "quizCreationTab2";
    }
}
 