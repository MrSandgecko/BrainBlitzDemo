package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.ChoicesEnt;

public interface ChoicesRep extends JpaRepository<ChoicesEnt, Long> {

    List<ChoicesEnt> findByQuestion_Id(Long question_id);

}
