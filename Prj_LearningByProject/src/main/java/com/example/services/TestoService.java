package com.example.services;

import java.util.List;

import com.example.entities.Frase;
import com.example.entities.Parola;

public interface TestoService {
	
	List<String> getParola();
	Parola getParolaById (int id);
	List<String> getTestoParola();
	
	List<String> getFrase();
	Frase getFraseById (int id);
	List<String> getTestoFrase();
	List<String> getParoleInTesto();
	int numeroParoleInFrase(String paroleInFrase);

}
