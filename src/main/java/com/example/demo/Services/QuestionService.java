package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.QuestionEnt;
import com.example.demo.Model.QuizEnt;
import com.example.demo.Repository.QuestionRep;

@Service

public class QuestionService {
    private QuestionRep questionRep;

    
    @Autowired
    public QuestionService(QuestionRep questionRep) {
        this.questionRep = questionRep;
    }

    public QuestionEnt saveQuestion(String questionText, QuizEnt quiz){
        QuestionEnt question = new QuestionEnt();
        question.setQuestiontext(questionText);
        question.setQuiz(quiz);
        return questionRep.save(question);
    }

    
}
