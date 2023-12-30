package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.AnswerEnt;
@Repository

public interface AnswerRep extends JpaRepository<AnswerEnt, Long> {
    
}
