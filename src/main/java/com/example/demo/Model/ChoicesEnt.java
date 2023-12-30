package com.example.demo.Model;




import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "choices")

public class ChoicesEnt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String choicesList;

    @ManyToOne
    @JoinColumn
    private QuestionEnt question;

    public void setQuestion(QuestionEnt question) {
        this.question = question;
    }

    public void setChoices(String choiceText) {
        this.choicesList = choiceText;
    }

}
