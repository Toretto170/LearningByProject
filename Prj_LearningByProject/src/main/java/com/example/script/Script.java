package com.example.script;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class Script {
	
	public void leggi(String pathFile) throws ScriptException{
		try {
			File f = new File(pathFile);
			if (f.exists()) {
				char[] endOfPhrase = {'.', '?', '!', ';'};
				
			    Scanner myReader = new Scanner(f);
			    while (myReader.hasNextLine()) {
			    	// TODO dividere testo in frasi usando endOfPhrase
			    }
			    myReader.close();
			}else throw new FileNotFoundException();
		 } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		 }
	}
}
