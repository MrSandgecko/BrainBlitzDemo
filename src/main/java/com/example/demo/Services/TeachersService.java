package com.example.demo.Services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.Model.TeachersEnt;
import com.example.demo.Repository.TeachersRep;


@Service
public class TeachersService {

    private final TeachersRep teachersRep;

    @Autowired
    public TeachersService(TeachersRep teachersRep) {
        this.teachersRep = teachersRep;
    }

    public void initializeTeachersAccounts() {

        if (teachersRep.count() == 0) {
            teachersRep.save(new TeachersEnt("admin", "admin"));
            teachersRep.save(new TeachersEnt("Teacher1", "teacher1"));
            teachersRep.save(new TeachersEnt("Teacher2", "teacher2"));
        }
    }

    public boolean isType(String username){
        Optional<TeachersEnt> teacherOptional = teachersRep.findByUsername(username);

        return teacherOptional.isPresent();
    }

    public boolean checkValidation(String username, String password){
        Optional<TeachersEnt> teacherOptional = teachersRep.findByUsernameAndPassword(username, password);

        if(teacherOptional.isPresent()){
            return true;
        }else{
            return false;
        }
    }


    
}
