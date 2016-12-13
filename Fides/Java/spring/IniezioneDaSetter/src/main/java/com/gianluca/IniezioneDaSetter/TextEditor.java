/**
 * 
 */
package com.gianluca.IniezioneDaSetter;

/**
 * @author aculnaig
 *
 */
public class TextEditor {
	
	private SpellChecker spellChecker;
	
	// Metodi setter per iniettare la dipendenza
	public void setSpellChecker(SpellChecker spellChecker) {
		System.out.println("All'interno di setSpellChecker.");
		
		this.spellChecker = spellChecker;
	}
	
	// Costruttore privo di argomenti
	public SpellChecker getSpellChecker() {
		return this.spellChecker;
	}
	
	// Metodo che esegue il controllo ortografico
	public void spellChecking() {
		spellChecker.checkSpelling();
	}

}
