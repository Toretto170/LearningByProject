package com.example.script;

import java.util.ArrayList;
import java.util.List;

public class Frase {
	private List<Parola> frase;
	
	public Frase(List<String> _frase) throws ScriptException{
		setFrase(_frase);
	}
	
	private void isFrase(List<String> _param) throws ScriptException{
		System.out.println(_param);
		List<Parola> _frase = new ArrayList<Parola>();;
		for (String string : _param) {
			Parola temp;
			try {
				temp = new Parola(string);
			} catch (ScriptException e) {
				throw new ScriptException(
					"Invalid parameter '_frase', error at index: "
					.concat(Integer.toString(_param.indexOf(string)))
					.concat(e.getMessage()) 
				);
			}
			_frase.add(temp);
		} 
		this.frase = _frase;
	}
	
	public List<Parola> getFrase(){
		return this.frase;
	}
	
	public void setFrase(List<String> _frase)  throws ScriptException{
		isFrase(_frase);
	}
}
