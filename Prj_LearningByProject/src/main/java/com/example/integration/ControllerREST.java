package com.example.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.services.ScriptService;

@RestController
@RequestMapping("api")
public class ControllerREST {
	
	@Autowired
	private ScriptService service;
	
	@GetMapping("analisi")
	public service.

}
