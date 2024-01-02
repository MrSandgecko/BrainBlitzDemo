package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.AnswersEnt;
import com.example.demo.Repository.AnswersRep;

@Service
public class AnswersService {
    @Autowired
    private AnswersRep answersRep;

    public AnswersEnt saveAnswer(AnswersEnt answer) {
        return answersRep.save(answer);
    }
}
