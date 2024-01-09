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

    List<QuestionsEnt> questionsList = questionService.getQuestionsByQuizId(quizId);
    List<QuestionsEnt> modifiedQuestionsList = modifyQuestions(questionsList);

    Map<Long, List<ChoicesEnt>> modifiedChoicesMap = new HashMap<>();

    for (QuestionsEnt question : modifiedQuestionsList) {
      List<ChoicesEnt> choicesList = choicesService.getChoicesByQuestionId(question.getId());
      List<ChoicesEnt> modifiedChoicesList = modifyChoices(choicesList);
      modifiedChoicesMap.put(question.getId(), modifiedChoicesList);
      System.out.println(modifiedChoicesMap);

    }

    model.addAttribute("quiz", quiz);
    model.addAttribute("questions", modifiedQuestionsList);
    model.addAttribute("choicesMap", modifiedChoicesMap);

    return "playQuizTab";
  }

  private List<ChoicesEnt> modifyChoices(List<ChoicesEnt> choicesList) {
    for (ChoicesEnt choice : choicesList) {
      String modifiedChoiceText = modifyChoiceText(choice.getChoices());
      choice.setChoices(modifiedChoiceText);
    }
    return choicesList;
  }

  private String modifyChoiceText(String originalChoiceText) {
    return originalChoiceText.replace("[", "").replace("]", "");
  }


   private List<QuestionsEnt> modifyQuestions(List<QuestionsEnt> questionsist) {
    for (QuestionsEnt question : questionsist) {
      String modifiedQuestionsText = modifyQuestionText(question.getQuestion());
      question.setQuestion(modifiedQuestionsText);
    }
    return questionsist;
  }

  private String modifyQuestionText(String originalChoiceText) {
    return originalChoiceText.replace("[", "").replace("]", "").replace("\"", "");
  }

}
