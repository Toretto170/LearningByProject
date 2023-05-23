package com.example.services;

import java.util.List;

import com.example.entities.Frase;
import com.example.entities.Parola;

public interface ScriptService {
	
	List<String> getParola();
	Parola getParolaById (int id);
	List<String> getTestoParola(Parola parola);
	void creaParola(String parola, Frase frase);
	
	List<String> getFrase();
	void creaFrase(String frase);
	Frase getFraseById (int id);
	List<String> getTestoFrase();
	List<String> getParoleInTesto();
	int numeroParoleInFrase(String paroleInFrase);

}
