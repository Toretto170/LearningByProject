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
public class ScriptServiceImpl implements ScriptService{
	
	@Autowired
	private FraseDAO fraseDao;
	@Autowired
	private ParolaDAO parolaDao;
	@Autowired
	EntityManager entityManager;
	
	@Override
	public List<String> getParola() {
		
		Set<String> parole = new TreeSet<>();
		
		for (String p : getParola()) {
			parole.add(p.getParoleInFrase());
		}
		
		return new ArrayList<>(parole);
	}

	@Override
	public Parola getParolaById(int id) {
		return parolaDao.getReferenceById(id);
	}

	@Override
	public List<String> getTestoParola() {
		return null;
	}

	@Override
	public List<String> getFrase() {
		Set<String> frasi = new TreeSet<>();
		
		for (String f : getFrase()) {
			frasi.add(f.getFraseinTesto);
		}
		
		return new ArrayList<>(frasi);
	}

	@Override
	public Frase getFraseById(int id) {
		return fraseDao.getReferenceById(id);
	}

	@Override
	public List<String> getTestoFrase() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getParoleInTesto() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int numeroParoleInFrase(String paroleInFrase) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public void creaParola(String parola, Frase frase) {
		Parola p = new Parola();
		p.setTestoParola(parola);
		p.setParoleInFrase(frase);
		parolaDao.save(p);
	  }

	@Override
	public void creaFrase(String frase) {
		Frase f = new Frase();
		f.setTestoFrase(frase);
		fraseDao.save(f);
	  }
}

