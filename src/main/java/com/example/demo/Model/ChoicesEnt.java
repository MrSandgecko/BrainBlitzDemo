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

    @ElementCollection
    @CollectionTable(name = "choice_content", joinColumns = @JoinColumn(name = "choices_id"))
    @Column(name = "choice_content")
    private List<String> choices; 

    public void setQuestion(QuestionsEnt question) {
        this.question = question;
    }

    public void setChoices(List<String> choices) {
        this.choices = choices;

    }

    @Override
    public String toString() {
        return "ChoicesEnt{" +
                "choiceContent='" + choices + '\'' +
                '}';
    }


}
