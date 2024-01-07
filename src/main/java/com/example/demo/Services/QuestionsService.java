package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.QuestionsEnt;
import com.example.demo.Model.QuizEnt;
import com.example.demo.Repository.QuestionsRep;

@Service
public class QuestionsService {
    @Autowired
    private QuestionsRep questionsRep;

    public QuestionsEnt saveQuestion(QuestionsEnt question) {
        return questionsRep.save(question);
    }

    public List<QuestionsEnt> getQuestionsByQuizId(Long quizId) {
        return questionsRep.findByQuizEnt_Id(quizId);
    }
}
