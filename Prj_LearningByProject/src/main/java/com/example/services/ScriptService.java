package com.example.services;

import java.util.ArrayList;

import com.example.entities.Frase;

public interface ScriptService {

    void creaParola(String parola, Frase frase);
    Frase creaFrase(String frase);
    ArrayList<String> analisi();
    String stampaArraylist(ArrayList<String> lista);
    void cancellaRecords();
}
