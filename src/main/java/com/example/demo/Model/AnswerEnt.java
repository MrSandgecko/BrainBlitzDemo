package com.example.demo.Model;

import java.util.List;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "answers")

public class AnswerEnt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private List<String> answer;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private QuestionEnt question;

    public void setQuestion(QuestionEnt question) {
        this.question = question;
    }

    public void setAnswer(String answerText) {
    }


    
}
