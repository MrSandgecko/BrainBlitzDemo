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

    private String questionContent;

    public void setQuiz(QuizEnt quiz) {
        this.quizEnt=quiz;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }
}
