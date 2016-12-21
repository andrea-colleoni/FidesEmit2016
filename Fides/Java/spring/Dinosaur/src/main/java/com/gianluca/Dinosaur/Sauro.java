/* vim:set ts=4 sw=4: */
/**
 * 
 * @author aculnaig
 * 
 */

package com.gianluca.Dinosaur;

import java.util.Locale;

import org.springframework.stereotype.Component;

@Component
public class Sauro implements Dinosaur {
	
	private double altezza;
	private double peso;
	
	public void setAltezza(double altezza) {
		this.altezza = altezza;
	}
	
	public double getAltezza() {
		return this.altezza;
	}
	
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public double getPeso() {
		return this.peso;
	}

	public void roar() {
		System.out.println(String.format(Locale.ENGLISH,
										 "Sauro[%.1f, %.1f]\nSauro...ROAR!!!",
				                         altezza, peso));
	}

}
