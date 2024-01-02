package com.example.demo.Controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.demo.Model.*;

import com.example.demo.Services.*;

import org.springframework.web.bind.annotation.*;

@Controller
public class QuizSavingController {

    @Autowired
    private QuizService quizService;

    @Autowired
    private QuestionsService questionService;

    @Autowired
    private ChoicesService choiceService;

    @Autowired
    private AnswersService answerService;

    @PostMapping("/saveQuiz")
    public String saveQuiz(@ModelAttribute QuizEnt quiz,
            @RequestParam String quizName,
            @RequestParam List<String> questionsList,
            @RequestParam List<List<String>> choicesList,
            @RequestParam List<String> answerList) {

        // newerList.add(newList.get(0));
        System.out.println(quizName);
        // System.out.println(questionsList.get(0));
        // System.out.println(choicesList.get(3));
        int choicesLoop = 0;
        int choicesLoopLimit = 4;
        String currentChoice = " ";

        for (int i = 0; i < questionsList.size(); i++) {

            if (i == 0) {
                System.out.println("First Question: " + questionsList.get(i));
            } else if (i == 1) {
                System.out.println("Second Question: " + questionsList.get(i));
            }

            for (int e = choicesLoop; e < choicesLoopLimit; e++) {

                if (choicesLoop < 4) {
                    currentChoice = "First Question choices: ";
                    System.out.println(currentChoice + choicesList.get(e));
                    System.out.println("e: " + e);
                    System.out.println("Limit: " + choicesLoopLimit);

                } else if (choicesLoop >= 4) {
                    currentChoice = "Second Question choices: ";
                    System.out.println(currentChoice + choicesList.get(e));
                    System.out.println("e: " + e);
                    System.out.println("Limit: " + choicesLoopLimit);

                }

            }
            choicesLoopLimit += 4;
            choicesLoop += 4;
            System.out.println("Limit: " + choicesLoopLimit);
            System.out.println("e: " + choicesLoop);

            System.out.println(answerList.get(i));

        }

        return "redirect:/teacherMain";
    }

}
