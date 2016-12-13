/**
 * 
 * @author aculnaig
 * 
 */

package com.gianluca.EventiSpring;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    
	public static void main(String[] args) {
		
		/* 
		 * Crea il contesto in base alle impostazioni dell'applicazione
		 * definite nel file beans.xml
		 * 
		 */
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        
        // Solleviamo l'evento ContextStartedEvent
        context.start();
        
        /* Recupera un bean avente id="helloWorld" nel file di configurazione beans.xml */
        HelloWorld hw = (HelloWorld) context.getBean("helloWorld");
        
        // Il messaggio
        System.out.println(hw.getMessage());
        
        // Solleviamo l'evento ContextStoppedEvent
        context.stop();
    }
}
