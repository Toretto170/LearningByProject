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
        p.setFraseFk(frase);
        parolaDao.save(p);
    }

    @Override
    public Frase creaFrase(String frase) {
        Frase f = new Frase();
        f.setTestoFrase(frase);
        return fraseDao.save(f);
    }
    
    @Override
    public ArrayList<String> analisi() {
		
    	ArrayList<String> analisi = new ArrayList<String>();
		int numeroFrasi = fraseDao.getNumeroFrasi();

    	    	
		analisi.add("Numero di caratteri nel testo: " + fraseDao.getNumeroCaratteriTotali());
		analisi.add("Numero di lettere nel testo: " + parolaDao.getNumeroLettereTotali());
		analisi.add("Numero di frasi nel testo: " + fraseDao.getNumeroFrasi());
		analisi.add("Numero di parole nel testo: " +  parolaDao.getNumeroParole());
		analisi.add("Numero medio caratteri per frase: " + fraseDao.getNumeroMedioCaratteriPerFrase());
		analisi.add("Numero medio caratteri per parola: " + parolaDao.getNumeroMedioCaratteriPerParola());
		analisi.add("Numero medio di parole per frase: " + parolaDao.getNumeroMedioParolePerFrase());
		analisi.add("Numero di caratteri della frase più lunga: " + fraseDao.getNumeroCaratteriFrasePiuLunga());
		analisi.add("Numero di caratteri della frase più breve: " + fraseDao.getNumeroCaratteriFrasePiuCorta());
		analisi.add("Numero di caratteri della parola più lunga: " + parolaDao.getNumeroCaratteriParolaPiuLunga());
		analisi.add("Numero di caratteri della parola più breve: " + parolaDao.getNumeroCaratteriParolaPiuCorta());
		
    	//Possono esserci risultati multipli
    	analisi.add("La frase più lunga risulta essere: " + stampaArraylist(fraseDao.getContenutoFrasePiuLunga()));
		analisi.add("La frase più breve risulta essere: " + stampaArraylist(fraseDao.getContenutoFrasePiuBreve()));
		analisi.add("La parola più lunga risulta essere: " + stampaArraylist(parolaDao.getContenutoParolaPiuLunga()));
		analisi.add("La parola più breve risulta essere: " + stampaArraylist(parolaDao.getContenutoParolaPiuBreve()));
		analisi.add("La parola o parole più usata/e nel testo: " + stampaArraylist(parolaDao.getParolaPiuUsataTesto()) + "per " + parolaDao.getNumeroParolaPiuUsataTesto() + " volta/e");

		for (int c=1; c<=numeroFrasi; c++) {
			
			analisi.add("La parola o parole più usata/e per '" + fraseDao.getTestoFrase(c) + "' sono: " + (stampaArraylist(parolaDao.getParolaPiuUsataInOgniFrase(c))) + "per " + parolaDao.getNumeroParolaPiuUsataInOgniFrase(c) + " volta/e");
			
		}
		
    	return analisi;
    	
    }

	@Override
	public String stampaArraylist(ArrayList<String> lista) {
		String result = "";
		for (String string : lista) {
			result += "[" + string + "] ";
		}
		return result;
	}

	@Override
	public void cancellaRecords() {
		parolaDao.deleteAll();;
		parolaDao.resetAutoIncrement();
		fraseDao.deleteAll();;
		fraseDao.resetAutoIncrement();
		
	}


}
