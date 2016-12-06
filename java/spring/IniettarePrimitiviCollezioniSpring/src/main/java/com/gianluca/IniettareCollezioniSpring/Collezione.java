/**
 * 
 */
package com.gianluca.IniettareCollezioniSpring;

/**
 * @author aculnaig
 *
 */

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Collezione {
	
	List addressList;
	Set addressSet;
	Map addressMap;
	Properties addressProp;
	
	// Metodi setter e getter
	public void setAddressList(List addressList) {
		this.addressList = addressList;
	}
	
	// Stampa tutti gli elementi della List e poi ritorna la List
	public List getAddressList() {
		System.out.println("Elementi della lista: " + this.addressList);
		
		return this.addressList;
	}
	
	public void setAddressSet(Set addressSet) {
		this.addressSet = addressSet;
	}
	
	// Stampa tutti gli elementi del Set e poi ritorna il Set
	public Set getAddressSet() {
		System.out.println("Elementi del set: " + this.addressSet);
			
		return this.addressSet;
	}
	
	public void setAddressMap(Map addressMap) {
		this.addressMap = addressMap;
	}

	// Stampa tutti gli elementi della Map e poi ritorna la Map
	public Map getAddressMap() {
		System.out.println("Elementi della map: " + this.addressMap);
			
		return this.addressMap;
	}
	
	public void setAddressProp(Properties addressProp) {
		this.addressProp = addressProp;
	}
	
	// Stampa tutti gli elementi della Properties e poi ritorna la Properties
	public Properties getAddressProp() {
		System.out.println("Elementi della properties: " + this.addressProp);
				
		return this.addressProp;
	}

}
