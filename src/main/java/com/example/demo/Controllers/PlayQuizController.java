package com.example.demo.Controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Model.ChoicesEnt;
import com.example.demo.Model.QuestionsEnt;
import com.example.demo.Model.QuizEnt;
import com.example.demo.Services.ChoicesService;
import com.example.demo.Services.QuestionsService;
import com.example.demo.Services.QuizService;

import org.springframework.ui.Model;

@Controller

public class PlayQuizController {

  @Autowired
  private QuizService quizService;

  @Autowired
  private QuestionsService questionService;

  @Autowired
  private ChoicesService choicesService;

  @GetMapping("/playQuizTab/{quizId}")
  public String showPlayQuizTab(@PathVariable Long quizId, Model model) {

    QuizEnt quiz = quizService.getQuizById(quizId);

    List<QuestionsEnt> questions = questionService.getQuestionsByQuizId(quizId);

    Map<Long, List<ChoicesEnt>> choicesMap = new HashMap<>();

    for (QuestionsEnt question : questions) {
      List<ChoicesEnt> choicesList = choicesService.getChoicesByQuestionId(question.getId());
      choicesMap.put(question.getId(), choicesList);
      System.out.println(choicesMap);

    }

    model.addAttribute("quiz", quiz);
    model.addAttribute("questions", questions);
    model.addAttribute("choicesMap", choicesMap);

    return "playQuizTab";
  }

}
