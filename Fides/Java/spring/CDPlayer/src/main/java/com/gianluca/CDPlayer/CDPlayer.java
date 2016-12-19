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

	/*@Autowired
	public CDPlayer(CompactDisc cd) {
		this.cd = cd;
	}*/

	@Autowired
	public void setCompactDisc(CompactDisc cd) {
		this.cd = cd;
	}

	/* La annotation @Autowired pu� essere applicata a qualsiasi metodo di una classe
	 * e funziona allo stesso metodo.
	 *
	 * In questo caso abbiamo definito un metodo insertDisc(CompactDisc cd) che fa
	 * esattamente la stessa cosa di setCompactDisc(CompactDisc cd) dopo
	 * l'istanziazione del bean da parte del contesto di Spring,
	 * ovvero iniettare la dipendenza CompactDisc in CDPlayer.
	 *
	 * L'unico vantaggio che pu� avere insertDisc � che il suo nome
	 * pu� richiamare pi� facilmente l'idea dell'inserimento
	 * di un CompactDisc nel CDPlayer rispetto a setCompactDisc.
	 *
	 *
	 * @Autowired
	 * public void insertDisc(CompactDisc cd) {
	 *     this.cd = cd;
	 * }
	 *
	 * Quindi l'annotation @Autowired cercer� il bean corrispondente al tipo CompactDisc
	 * e lo inietter� in CDPlayer.
	 *
	 * Questo sia che fosse un costruttore, un metodo setter, o qualsiasi altro metodo.
	 *
	 * Se non ci sono bean corrispondenti, Spring sollever� un'eccezione alla creazione
	 * del contesto dell'applicazione.
	 *
	 * Per evitare l'eccezione, si pu� impostare l'attributo 'required' di @Autowired a false:
	 *
	 * @Autowired(required=false)
	 * public CDPlayer(CompactDisc cd) {
	 *     this.cd = cd;
	 * }
	 *
	 * Quando required � uguale a false, Spring cercher� di effettuare l'autowiring.
	 *
	 * Se nessun bean adatto � stato trovato come dipendenza, lascier� il bean CDPlayer
	 * senza dipendenza.
	 *
	 * Bisogna prestare attenzione a impostare required su false, perch� lasciando
	 * una propriet� senza dipendenza potrebbe condurre a una NullPointerExceptions
	 * se non si controlla se le propriet� del bean sono null.
	 *
	 * Nell'eventualit� che pi� bean soddisfino la dipendenza, Spring sollever�
	 * un'eccezione indicando che non sa l'esatto bean da iniettare tramite autowiring.
	 * 
	 */

    public void play() {
		cd.play();
	}
}
