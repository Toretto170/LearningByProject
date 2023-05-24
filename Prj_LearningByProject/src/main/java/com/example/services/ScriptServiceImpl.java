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

    @Override
    public void creaParola(String parola, Frase frase) {
        Parola p = new Parola();
        p.setTestoParola(parola);
        p.setParoleInFrase(frase);
        parolaDao.save(p);
    }

    @Override
    public Frase creaFrase(String frase) {
        Frase f = new Frase();
        f.setTestoFrase(frase);
        return fraseDao.save(f);
    }
}
