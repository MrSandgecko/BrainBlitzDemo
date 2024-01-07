package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.QuestionsEnt;
import com.example.demo.Model.QuizEnt;

public interface QuestionsRep extends JpaRepository<QuestionsEnt, Long> {

    List<QuestionsEnt> findByQuizEnt_Id(Long quiz_ent_id);

}
