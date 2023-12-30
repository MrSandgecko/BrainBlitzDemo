package com.example.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.StudentsEnt;

public interface StudentsRep extends JpaRepository<StudentsEnt, Long> {
    Optional<StudentsEnt> findByUsername(String username);

    Optional<StudentsEnt> findByUsernameAndPassword(String username, String password);

}
