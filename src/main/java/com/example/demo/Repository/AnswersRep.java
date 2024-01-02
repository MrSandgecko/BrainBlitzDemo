package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.AnswersEnt;

public interface AnswersRep extends JpaRepository<AnswersEnt, Long> {

}
