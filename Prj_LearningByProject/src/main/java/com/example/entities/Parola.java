package com.example.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Parola {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String testoParola;
	
	@ManyToOne
	private Frase paroleInFrase;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTestoParola() {
		return testoParola;
	}

	public void setTestoParola(String testParola) {
		this.testoParola = testoParola;
	}

	public Frase getParoleInFrase() {
		return paroleInFrase;
	}

	public void setParoleInFrase(Frase paroleInFrase) {
		this.paroleInFrase = paroleInFrase;
	}
				 
}
