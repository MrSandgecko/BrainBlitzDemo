package com.example.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Model.AnswerEnt;
import com.example.demo.Model.ChoicesEnt;
import com.example.demo.Model.QuestionEnt;
import com.example.demo.Model.QuizEnt;
import com.example.demo.Repository.AnswerRep;
import com.example.demo.Repository.ChoicesRep;
import com.example.demo.Repository.QuestionRep;
import com.example.demo.Repository.QuizRep;

import org.springframework.web.bind.annotation.PostMapping;;

@Controller
public class QuizCreationController2 {

    private QuizRep quizRepository;
    private QuestionRep questionRepository;
    private ChoicesRep choicesRepository;
    private AnswerRep answerRepository;

    @Autowired
    public QuizCreationController2(
            AnswerRep answerRepository,
            ChoicesRep choicesRepository,
            QuestionRep questionRepository,
            QuizRep quizRepository

    ) {

        this.answerRepository = answerRepository;
        this.choicesRepository = choicesRepository;
        this.questionRepository = questionRepository;
        this.quizRepository = quizRepository;

    }

    /********************************
    //  * Getting Param from /quizCreationTab2
     *******************************/
    @GetMapping("/quizCreationTab2")
    public String showPage(@RequestParam int questionNumber, @RequestParam String quizName, Model model) {
        model.addAttribute("questionNumber", questionNumber);
        model.addAttribute("quizName", quizName);
        System.out.println(model.getAttribute("quizName"));
        return "quizCreationTab2";
    }

    /********************************
    //  * Saving a Quiz in the database (Still doesnt fully work)
     *******************************/
    @PostMapping("/saveQuiz")
    public String saveQuiz(@RequestParam String quizName, @RequestParam List<String> questionsList,
            @RequestParam List<List<String>> choicesList,
            @RequestParam List<List<String>> answerList) {

        String GetQuizName = quizName;
        List<String> questions = questionsList;
        List<List<String>> choices = choicesList;
        List<List<String>> answers = answerList;

        /****************
        //  * Check if there is even anything here
         ***************/
        System.out.println(GetQuizName + questions + choices + answers);

        QuizEnt quiz = new QuizEnt();
        quiz.setQuizName(GetQuizName);
        quizRepository.save(quiz);

        for (int i = 0; i < questionsList.size(); i++) {
            QuestionEnt question = new QuestionEnt();
            question.setQuiz(quiz);
            question.setQuestiontext(questionsList.get(i));
            System.out.println(questionsList.get(i));
            questionRepository.save(question);

            List<String> choicesForCurrentQuestion = choicesList.get(i);
            for (String choiceText : choicesForCurrentQuestion) {
                ChoicesEnt choice = new ChoicesEnt();
                choice.setQuestion(question);
                choice.setChoices(choiceText);

                choicesRepository.save(choice);
            }
            for (String answerText : answerList.get(i)) {
                AnswerEnt answer = new AnswerEnt();
                answer.setAnswer(answerText);
                answer.setQuestion(question);
                answerRepository.save(answer);
            }
        }

        return "redirect:/teacherMain";
    }

}
