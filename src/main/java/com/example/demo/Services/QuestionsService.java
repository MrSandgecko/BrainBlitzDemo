package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.QuestionsEnt;
import com.example.demo.Repository.QuestionsRep;

@Service
public class QuestionsService {
    @Autowired
    private QuestionsRep questionsRep;

    public QuestionsEnt saveQuestion(QuestionsEnt question) {
        return questionsRep.save(question);
    }
}
