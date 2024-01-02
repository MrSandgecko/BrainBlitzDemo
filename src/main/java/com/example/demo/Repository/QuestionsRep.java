package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.QuestionsEnt;

public interface QuestionsRep extends JpaRepository<QuestionsEnt, Long> {

}
