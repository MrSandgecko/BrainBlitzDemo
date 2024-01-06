package com.example.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.Model.QuizEnt;
import com.example.demo.Services.QuizService;

import org.springframework.ui.Model;


@Controller
public class QuizListController {

    @Autowired
    private QuizService quizService;

    @GetMapping("/quizList")
    public String showQuizListPage(Model model) {
        List<QuizEnt> quizzes = quizService.getQuizzes();
        model.addAttribute("quizzes", quizzes);
        return "quizList";
    }
    
    
}
