package com.example.demo.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "questions")
public class QuestionsEnt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private QuizEnt quizEnt;

    private String question;

    public void setQuiz(QuizEnt quiz) {
        this.quizEnt=quiz;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
