package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private final TeachersService teachersService;
    private final StudentsService studentsService;

    @Autowired
    public LoginService(TeachersService teachersService, StudentsService studentsService) {

        this.teachersService = teachersService;
        this.studentsService = studentsService;

        teachersService.initializeTeachersAccounts();
        studentsService.initializeStudentsAccoutns();

    }

    // /************************************************************************
    // *Check if account exists and if its a Teacher or Student? comes in handy.
    // *************************************************************************/
    public String getUserType(String username) {

        if (teachersService.isType(username)) {

            return "Teacher";
        } else if (studentsService.isType(username)) {
            return "Student";
        } else {
            return null;
        }
    }

    // /**********************************************
    // *Check if password is correct
    // ***********************************************/
    public boolean checkCreds(String userType, String username, String password) {
        if (userType.contains("Teacher")) {
            if (teachersService.checkValidation(username, password)) {
                return true;
            } else {
                return false;
            }
        } else {
            if (studentsService.checkValidation(username, password)) {
                return true;
            } else {
                return false;
            }
        }

    }
}
