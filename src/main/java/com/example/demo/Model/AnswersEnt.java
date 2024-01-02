package com.example.demo.Model;

import jakarta.persistence.*;


@Entity
@Table(name = "answers")
public class AnswersEnt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private QuestionsEnt question;

    private String answerContent;

    public void setQuestion(QuestionsEnt question) {
        this.question = question;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }
}
