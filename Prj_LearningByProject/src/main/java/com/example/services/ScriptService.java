package com.example.services;

import java.util.List;

import com.example.entities.Frase;
import com.example.entities.Parola;

public interface ScriptService {

    // Metodo per creare una nuova Parola all'interno di una Frase
    void creaParola(String parola, Frase frase);

    // Metodo per creare una nuova Frase
    Frase creaFrase(String frase);

}
