package com.example.script;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.io.IOException;

public class Script {
	
	// Costruisce un'espressione regolare che rappresenta una scelta tra una lista di stringhe
	private static String buildRegexOR(String[] list) {
		// NON utilizzare
		String toReturn = "(";
		String[] temp = {".", "?", "s", "n", "r"};
		List<String> needEscapeChar = Arrays.asList(temp);
		for (String string : list) {
			if (needEscapeChar.contains(string)) {
				toReturn += "\\\\";
			}
			toReturn += string + "|";
		}
		return toReturn + ")";
	}

	// Legge il testo e crea una Lista di frasi formata ognuna da una lista di parole
	public static List<Frase> leggiPerFrasiParole(String text) throws ScriptException {
		List<Frase> testo = new ArrayList<>();
		try {
			String[] preRegex = {".", "?", "!", ";"};
			List<String> frases = Arrays.asList(text.replaceAll("((\\r\\n)|(\\n))", "")
					.split("(\\.|\\?|!|;)(\\s)*")); // divide quando . ; ? ! seguito da 0 o più spazi

			for (String string : frases) {
				Frase aa = new Frase(Arrays.asList(
						string.replaceAll("(,|:|\\\"|-)", "")
								.replaceAll("\\'", " ")
								.split(" ")));
				testo.add(aa);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return testo;
	}
	
	// Suddivide il testo in frasi con punteggiatura e restituisce una lista di frasi
	public static List<String> leggiPerFrasi(String text) {
        List<String> sentences = new ArrayList<>();

        // Rimuovi eventuali spazi bianchi all'inizio e alla fine del testo
        text = text.trim();

        // Crea un delimitatore basato sulla punteggiatura comune delle frasi
        String delimiter = "(?<=[.!?])\\s+";

        // Dividi il testo in frasi utilizzando il delimitatore
        String[] splitText = text.split(delimiter);

        // Aggiungi le frasi alla lista
        for (String sentence : splitText) {
            sentences.add(sentence.trim());
        }

        return sentences;
    }
}
