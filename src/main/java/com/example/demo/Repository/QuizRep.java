package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.QuizEnt;


public interface QuizRep extends JpaRepository<QuizEnt, Long> {
    
}
