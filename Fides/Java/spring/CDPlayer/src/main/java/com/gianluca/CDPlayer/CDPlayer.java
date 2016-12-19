/* vim:set ts=4 sw=4: */
/**
 *
 * @author aculnaig
 *
 */

package com.gianluca.CDPlayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/* La classe CDPlayer implementa l'interfaccia MediaPlayer */

@Component
public class CDPlayer implements MediaPlayer {

	private CompactDisc cd;

	@Autowired
	public CDPlayer(CompactDisc cd) {
		this.cd = cd;
	}

	@Autowired
	public void setCompactDisc(CompactDisc cd) {
		this.cd = cd;
	}

	/* La annotation @Autowired può essere applicata a qualsiasi metodo di una classe
	 * e funziona allo stesso metodo.
	 *
	 * In questo caso abbiamo definito un metodo insertDisc(CompactDisc cd) che fa
	 * esattamente la stessa cosa di setCompactDisc(CompactDisc cd) dopo
	 * l'istanziazione del bean da parte del contesto di Spring,
	 * ovvero iniettare la dipendenza CompactDisc in CDPlayer.
	 *
	 * L'unico vantaggio che può avere insertDisc è che il suo nome
	 * può richiamare più facilmente l'idea dell'inserimento
	 * di un CompactDisc nel CDPlayer rispetto a setCompactDisc.
	 *
	 *
	 * @Autowired
	 * public void insertDisc(CompactDisc cd) {
	 *     this.cd = cd;
	 * }
	 *
	 * Quindi l'annotation @Autowired cercerà il bean corrispondente al tipo CompactDisc
	 * e lo inietterà in CDPlayer.
	 *
	 * Questo sia che fosse un costruttore, un metodo setter, o qualsiasi altro metodo.
	 *
	 * Se non ci sono bean corrispondenti, Spring solleverà un'eccezione alla creazione
	 * del contesto dell'applicazione.
	 *
	 * Per evitare l'eccezione, si può impostare l'attributo 'required' di @Autowired a false:
	 *
	 * @Autowired(required=false)
	 * public CDPlayer(CompactDisc cd) {
	 *     this.cd = cd;
	 * }
	 *
	 * Quando required è uguale a false, Spring cercherà di effettuare l'autowiring.
	 *
	 * Se nessun bean adatto è stato trovato come dipendenza, lascierà il bean CDPlayer
	 * senza dipendenza.
	 *
	 * Bisogna prestare attenzione a impostare required su false, perché lasciando
	 * una proprietà senza dipendenza potrebbe condurre a una NullPointerExceptions
	 * se non si controlla se le proprietà del bean sono null.
	 *
	 * Nell'eventualità che più bean soddisfino la dipendenza, Spring solleverà
	 * un'eccezione indicando che non sa l'esatto bean da iniettare tramite autowiring.
	 * 
	 */

    public void play() {
		cd.play();
	}
}
