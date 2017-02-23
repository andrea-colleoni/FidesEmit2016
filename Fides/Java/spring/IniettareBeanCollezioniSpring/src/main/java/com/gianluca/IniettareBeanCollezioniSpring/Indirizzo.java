/**
 * 
 */
package com.gianluca.IniettareBeanCollezioniSpring;

/**
 * @author aculnaig
 *
 */
public class Indirizzo {
	
	private String via;
	private int civico;
	
	/* Costruttore con relativi parametri 
	 * per effettura la iniezione della dipendenza
	 * tramite costruttore */
	public Indirizzo(String via, int civico) {
		System.out.println("Entrato nel costruttore Indirizzo");
		
		this.via = via;
		this.civico = civico;
		
		System.out.println("Oggetto Indirizzo costruito\n" +
						   "via: " + this.via + "\n" +
						   "civico: " + this.civico);
	}
	
	// Setter and Getter
	public void setVia(String via) {
		this.via = via;
	}
	
	public String getVia() {
		return this.via;
	}
	
	public void setCivico(int civico) {
		this.civico = civico;
	}
	
	public int getCivico() {
		return this.civico;
	}

}
