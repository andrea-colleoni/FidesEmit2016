/**
 * 
 * @author aculnaig
 * 
 */

package com.gianluca.AnnotationConfigurationBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;


public class App {
    
	public static void main(String[] args) {
		
		/* 
		 * Crea il contesto applicativo in base alle impostazioni
		 * della classe annotata HelloWorldConfig.class che abbiamo definito 
		 * 
		 */
		ApplicationContext context = new AnnotationConfigApplicationContext(HelloWorldConfig.class);

		/* Recupera un bean avente tipo HelloWorld */
		HelloWorld hw = context.getBean(HelloWorld.class);
		
		hw.setMessage("Hello World from aculnaig!");
		System.out.println(hw.getMessage());
    	
    }
}
