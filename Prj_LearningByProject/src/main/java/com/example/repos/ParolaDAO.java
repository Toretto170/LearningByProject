package com.example.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Parola;

@Repository
public interface ParolaDAO extends JpaRepository<Parola, Integer>{

}
