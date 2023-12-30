package com.example.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.TeachersEnt;

public interface TeachersRep extends JpaRepository<TeachersEnt, Long> {
    Optional<TeachersEnt> findByUsername(String username);
    Optional<TeachersEnt> findByUsernameAndPassword(String username, String password);
    
}
