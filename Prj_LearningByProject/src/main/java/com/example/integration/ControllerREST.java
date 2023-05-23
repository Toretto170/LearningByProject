package com.example.integration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.example.script.Frase;
import com.example.script.Parola;
import com.example.script.Script;
import com.example.script.ScriptException;
import com.example.services.ScriptServiceImpl;

@RestController
@RequestMapping("api")
public class ControllerREST {
	
	@Autowired
	private ScriptServiceImpl serviceimpl;
	
	//@GetMapping("analisi")
	//public service.

	
    // Endpoint per elaborare il testo
    @PostMapping("/process")
    public ResponseEntity<List<Frase>> processText(@RequestBody String text) {
        try {
            // Chiama Script.leggi(text) per elaborare il testo e ottenere una lista di oggetti Frase
            List<Frase> result = Script.leggiPerFrasiParole(text);
            // Suddivide il testo in frasi utilizzando Script.splitTextIntoSentences(text)
            List<String> result2 = Script.leggiPerFrasi(text);
            
            int scorriListaFrasi = 0;

            // Itera su ogni oggetto Frase nella lista risultato
            for (Frase frase : result) {
				
                // Ottiene la frase corrispondente con punteggiatura dalla lista result2
                String fraseconpunteggiatura = result2.get(scorriListaFrasi);
                
                // Crea un'istanza di com.example.entities.Frase utilizzando serviceimpl
                com.example.entities.Frase fraseperdb = serviceimpl.creaFrase(fraseconpunteggiatura);
                
                // Itera su ogni oggetto Parola nella frase corrente
                for (Parola frase2 : frase.getFrase()) {
                    
                    // Ottiene il testo dell'oggetto Parola
                    String parola = frase2.getText();
                    
                    // Crea una voce per l'oggetto Parola corrente utilizzando serviceimpl
                    serviceimpl.creaParola(parola, fraseperdb);
                }
                
                // Incrementa il contatore per l'iterazione sulle frasi
                scorriListaFrasi++;
			}
            
            // Restituisce la lista elaborata di oggetti Frase
            return ResponseEntity.ok(result);
        } catch (ScriptException e) {
            e.printStackTrace();
            
            // Se si verifica un'eccezione, restituisce un errore interno del server
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Configura il filtro CORS --- altrimenti non funziona l'upload
    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("*");
        config.addAllowedMethod("*");
        config.addAllowedHeader("*");

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }
}
