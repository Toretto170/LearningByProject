package com.example.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.entities.Parola;
import com.example.entities.Frase;
import com.example.repos.ParolaDAO;

import jakarta.persistence.EntityManager;

import com.example.repos.FraseDAO;

@Service
public class ScriptServiceImpl implements ScriptService {

    @Autowired
    private FraseDAO fraseDao;
    @Autowired
    private ParolaDAO parolaDao;

    // Implementazione del metodo per creare una nuova Parola all'interno di una Frase
    @Override
    public void creaParola(String parola, Frase frase) {
        // Crea un nuovo oggetto Parola
        Parola p = new Parola();
        p.setTestoParola(parola);
        p.setParoleInFrase(frase);
        // Salva l'oggetto Parola utilizzando il parolaDao
        parolaDao.save(p);
    }

    // Implementazione del metodo per creare una nuova Frase
    @Override
    public Frase creaFrase(String frase) {
        // Crea un nuovo oggetto Frase
        Frase f = new Frase();
        f.setTestoFrase(frase);
        // Salva l'oggetto Frase utilizzando il fraseDao e lo restituisce
        return fraseDao.save(f);
    }
}
