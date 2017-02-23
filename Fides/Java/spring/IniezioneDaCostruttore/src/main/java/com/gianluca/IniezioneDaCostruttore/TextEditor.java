/**
 * 
 */
package com.gianluca.IniezioneDaCostruttore;

/**
 * @author aculnaig
 *
 */
public class TextEditor {
	
	// Il correttore ortografico
	private SpellChecker spellChecker;
	
	/* Costruttore della classe TextEditor
	 * 
	 * @param: SpellChecker
	 * @return: TextEditor
	 * 
	 */
	public TextEditor(SpellChecker spellCheker) {
		System.out.println("All'interno del costruttore " + TextEditor.class.getSimpleName());
		this.spellChecker = spellCheker;
	}
	
	/* Metodo chiamato per la correzione ortografica. */
	public void spellChecking() {
		spellChecker.checkSpelling();
	}

}
