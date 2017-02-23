/**
 * 
 * @author aculnaig
 * 
 */

package com.gianluca.AnnotationConfigurationBean;

/* 
 * Classe HelloWorld, gli oggetti istanziati di tale classe
 * verranno registrati come bean nel contesto di Spring
 * grazie alla classe HelloWorldConfig 
 * 
 */

public class HelloWorld {

	private String message;
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}
}
