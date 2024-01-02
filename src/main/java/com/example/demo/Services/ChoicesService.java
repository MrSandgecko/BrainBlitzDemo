package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.ChoicesEnt;
import com.example.demo.Repository.ChoicesRep;

@Service
public class ChoicesService {
    @Autowired
    private ChoicesRep choicesRep;
    
    public ChoicesEnt saveChoice(ChoicesEnt choice){
        return choicesRep.save(choice);
    }
    
}
