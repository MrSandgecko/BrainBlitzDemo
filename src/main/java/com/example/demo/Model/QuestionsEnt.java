package com.example.demo.Model;

import java.util.List;

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

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<ChoicesEnt> choices;

    public void setQuiz(QuizEnt quiz) {
        this.quizEnt = quiz;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return this.question;
    }

    public Long getId() {
        return this.id;
    }

    public List<ChoicesEnt> getChoices() {

        return this.choices;
    }

}
