package com.example.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Parola;
import com.example.entities.Frase;
import com.example.repos.ParolaDAO;
import com.example.repos.FraseDAO;

@Service
public class TestoServiceImpl implements TestoService{
	
	@Autowired
	private FraseDAO fraseDao;
	private ParolaDAO parolaDao;
	
	@Override
	public List<String> getParola() {
		
		Set<String> parole = new TreeSet<>();
		
		for (String p : getParola()) {
			parole.add(p.getParole());
		}
		
		return new ArrayList<>(parole);
	}

	@Override
	public List<Provincia> getProvince() {
		return dao.findAll();
	}

	@Override
	public List<Provincia> getProvinceByRegione(String regione) {
		return null;
	}

	@Override
	public Provincia getProvinciaById(int id) {
		return dao.getReferenceById(id);
	}

	@Override
	public Parola getParolaById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getTestoParola() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getFrase() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Frase getFraseById(int id) {
		// TODO Auto-generated method stub
		return null;
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

}
