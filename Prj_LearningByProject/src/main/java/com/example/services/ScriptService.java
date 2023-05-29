package com.example.services;

import java.util.ArrayList;
import java.util.List;

import com.example.entities.Frase;
import com.example.entities.Parola;

public interface ScriptService {

    void creaParola(String parola, Frase frase);
    Frase creaFrase(String frase);
    ArrayList<String> analisi();
    String stampaArraylist(ArrayList<String> lista);
    void cancellaRecords();
}
