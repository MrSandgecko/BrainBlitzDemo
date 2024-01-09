package com.example.demo.Model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "choices")
public class ChoicesEnt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private QuestionsEnt question;

    private String choices; 

    public void setQuestion(QuestionsEnt question) {
        this.question = question;
    }

    public void setChoices(String choices) {
        this.choices = choices;
    }

    public String getChoices(){
        return this.choices;
    }

}
