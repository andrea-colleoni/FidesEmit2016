/**
 * 
 */
package com.gianluca.Autowiring;

/**
 * @author Training
 *
 */
public class TextEditor {
	
	// Il correttore ortografico
	private SpellChecker spellChecker;
	private String name;
	
	/* Costruttore:
	 * @param il correttore ortografico 
	 * @param il nome */
	
	public TextEditor(SpellChecker spellChecker, String name) {
		this.spellChecker = spellChecker;
		this.name = name;
	}
	
	public void setSpellChecker(SpellChecker spellChecker) {
		this.spellChecker = spellChecker;
	}
	
	public SpellChecker getSpellChecker() {
		return this.spellChecker;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	/* Metodo chiamato per la correzione ortografica. */
	public void spellChecking() {
		spellChecker.checkSpelling();
	}

}
