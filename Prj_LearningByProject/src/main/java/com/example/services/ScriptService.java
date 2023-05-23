package com.example.services;

import java.util.List;

import com.example.entities.Frase;
import com.example.entities.Parola;

public interface ScriptService {
	
	List<String> getParola();
	Parola getParolaById (int id);
	void creaParola(String parola, Frase frase);
	
	List<String> getFrase();
	void creaFrase(String frase);
	Frase getFraseById (int id);
	List<String> getFrasiInTesto();
	List<String> getParoleInTesto();
	int numeroParoleInFrase(String paroleInFrase);

}
