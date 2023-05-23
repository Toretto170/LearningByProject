package com.example.script;


import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.IOException;

public class Script {
	public static void main(String[] args) throws ScriptException {
		leggi("C:\\Users\\stepr\\Downloads\\a.txt");
	}
	
	private static String buildRegexOR(String[] list) {
		String toReturn = "(";
		String[] temp = {".", "?", "s", "n", "r"};
		List needEscapeChar = Arrays.asList(temp);
		for (String string : list) {
			if (needEscapeChar.contains(string)) {toReturn+="\\\\";}
			toReturn+=string+"|";
		}
		return toReturn+")";
	}
	
	public static List<Frase> leggi(String pathFile) throws ScriptException{
		List<Frase> testo = new ArrayList<Frase>();
		try {
			String[] preRegex = {".", "?", "!", ";"};
		    String text = Files.readString(Path.of(pathFile));
			List<String> frases =Arrays.asList( text.replaceAll("((\\r\\n)|(\\n))", "") // replace new line char, it should work for both Windows and Unix-like OS
									.split("(\\.|\\?|!|;)(\s)*")); // split when . ; ? ! followed by 0 or more spaces
			
			for (String string : frases) {
				Frase aa = new Frase(Arrays.asList(
						string.replaceAll("(,|:|\\\"|-)", "")
							  .replaceAll("\\'", " ")
							  .split(" ")));
				testo.add(aa);
				//for (Parola s : aa.getFrase()) {
				//	System.out.println(s.getText());
				//}
			}

		 } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return testo;
	}
}


