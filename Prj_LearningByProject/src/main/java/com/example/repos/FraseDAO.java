package com.example.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Frase;

public interface FraseDAO extends JpaRepository<Frase, Integer>{

}
