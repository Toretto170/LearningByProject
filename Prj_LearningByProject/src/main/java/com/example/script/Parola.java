package com.example.script;

public class Parola {
	private String text;
	
	public Parola(String _text) throws ScriptException{
		setText(_text);
	}

	public void setText(String _text) throws ScriptException{
		if (isParola(_text)) this.text = _text;
	}
	
	public String getText() {
		return this.text;
	}
	
	private boolean isParola(String text) throws ScriptException{
		if (text.contains("\\s")) throw new ScriptException("Invalid parameter: '_text', Parola cannot contain any space.");
		// eventually add other checks
		return true;
	}
}
