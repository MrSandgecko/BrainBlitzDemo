package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.AnswerEnt;
import com.example.demo.Model.QuestionEnt;
import com.example.demo.Repository.AnswerRep;

@Service

public class AnswerService {
    private AnswerRep answerRep;

    @Autowired
    public AnswerService(AnswerRep answerRep) {
        this.answerRep = answerRep;
    }

    public void saveAnswer(String answerText, QuestionEnt question) {
        AnswerEnt answer = new AnswerEnt();
        answer.setAnswer(answerText);
        answer.setQuestion(question);
        answerRep.save(answer);
    }

}
