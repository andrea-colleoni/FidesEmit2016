/**
 * @author aculnaig
 *
 */

package com.gianluca.BeanPostConstructPreDestroy;

import javax.annotation.*;

public class HelloWorld {
	
	private String message;
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}
	
	// Metodo di callback invocato subito dopo la costruzione del bean
	@PostConstruct
	public void init() {
		System.out.println("Il Bean sta chiamando init() dopo la sua creazione.");
	}
	
	// Metodo di callback invocato subito prima della distruzione del bean
	@PreDestroy
	public void destroy() {
		System.out.println("Il Bean sta per essere distrutto.");
	}

}
