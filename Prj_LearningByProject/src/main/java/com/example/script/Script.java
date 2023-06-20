package com.example.script;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Script {
	
	// Costruisce un'espressione regolare che rappresenta una scelta tra una lista di stringhe
	private static String buildRegexOR(List<String> tempList) {
		// NON utilizzare
		ArrayList<String> list = new ArrayList<String>(tempList);
		String toReturn = "(";
		List<String> needEscapeChar = Arrays.asList(new String[]{".", "?", "s", "n", "r", "r n"});
		for (String string : list) {
			if (needEscapeChar.contains(string)) {
				if (string.contains(" ")) {
					string = " "+string;
					string = string.replaceAll(" ", "\\\\\\\\");
				}else {toReturn += "\\\\";}
			}
			
			if (list.indexOf(string) == list.size()-1 || list.size() == 1){
				toReturn += string;
			} else{
				toReturn += string + "|";
			}
		}
		toReturn += ")";
		return toReturn;
	}

	// Legge il testo e crea una Lista di frasi formata ognuna da una lista di parole
	public static List<Frase> leggiPerFrasiParole(String text) throws ScriptException {
		List<Frase> completeText = new ArrayList<>();
		try {
			List<String> phrases = leggiPerFrasi(text);
			for (String string : phrases) {
				String[] tempArr = string
					.replaceAll(buildRegexOR(Arrays.asList(".", "?", "!", ";")), "")
					.replaceAll("(,|:|\"|-|\\'|“|”)", " ")
					.strip()
					.split("(\\s)+");
				Frase temPhrases = new Frase(Arrays.asList(tempArr)); 
				completeText.add(temPhrases);
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return completeText;
	}
	
	// Suddivide il testo in frasi con punteggiatura e restituisce una lista di frasi
	public static List<String> leggiPerFrasi(String text) {
	    List<String> sentences = new ArrayList<>();

	    // Rimuovi eventuali spazi bianchi all'inizio e alla fine del testo
	    text = text.trim();

	    // Crea un delimitatore basato sulla punteggiatura comune delle frasi
	    String delimiter = "(?<=[.!?;])\\s+|\\n+";

	    // Dividi il testo in frasi utilizzando il delimitatore
	    String[] splitText = text.split(delimiter);

	    // Aggiungi le frasi alla lista
	    for (String sentence : splitText) {
	        sentences.add(sentence.trim());
	    }

	    return sentences;
	}
}
