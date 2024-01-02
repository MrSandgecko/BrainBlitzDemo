package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.ChoicesEnt;

public interface ChoicesRep extends JpaRepository<ChoicesEnt, Long>{
    
}
