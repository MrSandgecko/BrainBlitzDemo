package com.example.demo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QuizCreationController2 {

    /********************************************
     ** // * Getting Param from /quizCreationTab2
     ********************************************/
    @GetMapping("/quizCreationTab2")
    public String showPage(@RequestParam int questionNumber, @RequestParam String quizName,
            @RequestParam String category, @RequestParam int quizTime, Model model) {
        model.addAttribute("questionNumber", questionNumber);
        model.addAttribute("quizName", quizName);
        model.addAttribute("category", category);
        model.addAttribute("quizTime", quizTime);
        System.out.println(model.getAttribute("quizName"));
        return "quizCreationTab2";
    }
}

/*****************************************************************
 ** // * Saving a Quiz in the database (In QuizSavingController now!!)
 ****************************************************************/
