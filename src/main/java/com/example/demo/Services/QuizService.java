package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.QuizEnt;
import com.example.demo.Repository.QuizRep;

@Service
public class QuizService {

    private final QuizRep quizRep;

    @Autowired
    public QuizService(QuizRep quizRep) {
        this.quizRep = quizRep;
    }

    public QuizEnt saveQuiz(String quizName) {
        /******** Java XD *********/
        QuizEnt quiz = new QuizEnt();

        quiz.setQuizName(quizName);
        return quizRep.save(quiz);
    }
}