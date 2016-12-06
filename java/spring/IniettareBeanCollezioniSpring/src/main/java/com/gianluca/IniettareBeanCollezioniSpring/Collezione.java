/**
 * 
 */
package com.gianluca.IniettareBeanCollezioniSpring;

/**
 * @author aculnaig
 *
 */

import java.util.List;

public class Collezione {
	
	List addressList;
	
	// Metodi setter e getter
	public void setAddressList(List addressList) {
		System.out.println("Entrato in setAddressList()");
		
		this.addressList = addressList;
		
		System.out.println("Lista settata");
	}
	
	// Stampa tutti gli elementi della List e poi ritorna la List
	public List getAddressList() {
		System.out.println("Elementi della lista: " + this.addressList);
		
		return this.addressList;
	}
	
	

}
