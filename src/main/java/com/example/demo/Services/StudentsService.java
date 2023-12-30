package com.example.demo.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.StudentsEnt;
import com.example.demo.Model.TeachersEnt;
import com.example.demo.Repository.StudentsRep;

@Service
public class StudentsService {

    private StudentsRep studentsRep;

    @Autowired
    public StudentsService(StudentsRep studentsRep) {
        this.studentsRep = studentsRep;
    }

    public void initializeStudentsAccoutns() {
        if (studentsRep.count() == 0) {
            studentsRep.save(new StudentsEnt("notadmin", "notadmin"));
            studentsRep.save(new StudentsEnt("Student1", "student1"));
            studentsRep.save(new StudentsEnt("Student2", "student2"));
        }
    }

    public boolean isType(String username) {
        Optional<StudentsEnt> StudentOptional = studentsRep.findByUsername(username);

        return StudentOptional.isPresent();
    }

    public boolean checkValidation(String username, String password) {
        Optional<StudentsEnt> teacherOptional = studentsRep.findByUsernameAndPassword(username, password);

        if (teacherOptional.isPresent()) {
            return true;
        } else {
            return false;
        }
    }

}
