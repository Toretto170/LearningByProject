package com.example.services;

import java.util.List;

import com.example.entities.Parola;

public interface ParolaService {
	
	List<String> getParola();
	
	Parola getParolaById (int id);
	
	List<String> getTestoParola();
	
}
