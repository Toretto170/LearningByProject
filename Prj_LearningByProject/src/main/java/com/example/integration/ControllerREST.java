package com.example.integration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Frase;
import com.example.entities.Parola;
import com.example.services.ScriptService;
import com.example.services.ScriptServiceImpl;

@RestController
@RequestMapping ("api")
public class ControllerREST {
	
	@Autowired
	private ScriptService serviceScript;
	
	@GetMapping("parola")
	List<String> getParola(){
		return
	}
	
	@GetMapping("frase")
	List<String> getFrase(){
		return serviceFrase.getFrase();
	}
	
	@GetMapping("testo")
	List<String> getTesto(){
		return serviceTesto.getTesto();
	}

	@GetMapping("parola/{id}")
	Parola getProvincia(@PathVariable int id) {
		return serviceParola.getParolaById(id);
	}
	
	@GetMapping("frase/{id}")
	Frase getFrase(@PathVariable int id) {
		return serviceFrase.getFraseById(id); 
	}
	
	@GetMapping ("testoParola")
	List<String> getTestoParola(){
		return serviceParola.getTestoParola();
	}
	
	@GetMapping ("testoFrase")
	List<String> getTestoFrase(){
		return serviceFrase.getTestoFrase();
	}

}
