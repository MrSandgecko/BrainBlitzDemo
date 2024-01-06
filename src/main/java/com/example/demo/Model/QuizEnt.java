package com.example.demo.Model;

import java.util.List;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "thequizzes")
public class QuizEnt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String quizName;
    private String category;
    private int quizTime;

    @OneToMany(mappedBy = "quizEnt", cascade = CascadeType.ALL)
    private List<QuestionsEnt> questions;

    public void setQuiz(String quizName) {
        this.quizName = quizName;
    }

    public void setCategory(String category){

        this.category = category;
    }

    public int getNumberOfQuestions() {
        return questions != null ? questions.size() : 0;
    }

    public void setQuizTime(int quizTime) {
        this.quizTime = quizTime;
    }

}
