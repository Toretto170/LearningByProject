package com.example.script;

import java.util.List;

public class Frase {
	private List<Parola> frase;
	
	public Frase(List<String> _frase) throws ScriptException{
		setFrase(_frase);
	}
	
	private void isFrase(List<String> _frase) throws ScriptException{
		for (String string : _frase) {
			Parola temp;
			try {
				temp = new Parola(string);
			} catch (ScriptException e) {
				throw new ScriptException(
					"Invalid parameter '_frase', error at index: "
					.concat(Integer.toString(_frase.indexOf(string)))
					.concat(e.getMessage()) 
				);
			}
			frase.add(temp);
		} 
	}
	
	public List<Parola> getFrase(){
		return this.frase;
	}
	
	public void setFrase(List<String> _frase)  throws ScriptException{
		isFrase(_frase);
	}
}
