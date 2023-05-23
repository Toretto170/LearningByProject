package com.example.services;

import java.util.List;

import com.example.entities.Frase;
import com.example.entities.Parola;

public interface ScriptService {
	
	void creaParola(String parola, Frase frase);

	void creaFrase(String frase);

}
