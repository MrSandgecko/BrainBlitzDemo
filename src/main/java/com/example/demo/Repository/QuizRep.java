package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.QuizEnt;
@Repository

public interface QuizRep extends JpaRepository<QuizEnt, Long> {
    
}