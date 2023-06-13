package com.example.script;

public class Parola {
    private String text;

    public Parola(String _text) throws ScriptException {
        setText(_text);
    }

    // Imposta il testo della parola e verifica la validità
    public void setText(String _text) throws ScriptException {
    	_text = _text.replaceAll("\\.|\\?|!|;", "");
        if (isParola(_text))
            this.text = _text;
    }

    // Restituisce il testo della parola
    public String getText() {
        return this.text;
    }

    // Verifica se il testo passato come parametro rappresenta una parola valida
    private boolean isParola(String text) throws ScriptException {
    	text = text.replaceAll("(\\n|\\r|\\s|\\t)", text);
        if (text.length() < 1)
            throw new ScriptException("Parametro non valido: 'text', la parola non può contenere spazi.");
        // eventually add other checks
        return true;
    }
}
