package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.QuestionEnt;
@Repository

public interface QuestionRep extends JpaRepository<QuestionEnt, Long> {
    
}
