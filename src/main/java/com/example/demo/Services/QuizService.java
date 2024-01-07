package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.QuestionsEnt;
import com.example.demo.Model.QuizEnt;
import com.example.demo.Repository.QuizRep;

@Service
public class QuizService {
    @Autowired
    private QuizRep quizRep;

    public QuizEnt saveQuiz(QuizEnt quiz) {
        return quizRep.save(quiz);
    }

    

    public List<QuizEnt> getQuizzes() {
        return quizRep.findAll();

    }

    public QuizEnt getQuizById(Long quizId) {

        return quizRep.findById(quizId).orElse(null);
    }
}
