/**
 * 
 */
package com.gianluca.helloworldspring;

/**
 * @author aculnaig
 *
 */
public class HelloWorld {
	
	// Messaggio da visualizzare
	private String message;
	
	// Metodo usato per iniettare il valore della variabile
	// message definito nel file beans.xml
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}

}
