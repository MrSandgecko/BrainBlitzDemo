package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.ChoicesEnt;
import com.example.demo.Model.QuestionEnt;
import com.example.demo.Repository.ChoicesRep;

@Service 

public class ChoicesService {
    private  ChoicesRep choiceRep;

     @Autowired
    public ChoicesService(ChoicesRep choiceRep) {
        this.choiceRep = choiceRep;
    }
  
    public void saveChoices(String choiceText, QuestionEnt question) {
          ChoicesEnt choices = new ChoicesEnt();
        choices.setChoices(choiceText);
        choices.setQuestion(question);
        choiceRep.save(choices);
    }
    
}
