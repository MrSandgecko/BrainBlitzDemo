package com.example.demo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.ui.Model;

@Controller
public class QuizCreationController {

    @GetMapping("/quizCreationTab")
    public String showTeacherMainPage() {
        return "quizCreationTab";
    }

    @PostMapping("/quizCreationTab")
    public String processQuizCreation(@RequestParam int questionNumber, @RequestParam String quizName, Model model) {
        model.addAttribute("questionNumber", questionNumber);
        model.addAttribute("quizName", quizName);
        


        return "redirect:/quizCreationTab2?questionNumber=" + questionNumber + "&quizName=" + quizName;
    }

}
