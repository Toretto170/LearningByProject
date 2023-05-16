package com.example.services;

import java.util.List;

import com.example.entities.Frase;

public interface FraseService {
	
	List<String> getFrase();
	
	Frase getFraseById (int id);
	
	List<String> getTestoFrase();
	
}
