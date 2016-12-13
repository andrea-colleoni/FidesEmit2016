/**
 * 
 * @author aculnaig
 *
 */

package com.gianluca.BeanPostConstructPreDestroy;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	
    public static void main(String[] args) {
    	
    	/* 
    	 * Crea il contesto in base alle impostazioni dell'applicazione
    	 * definite nel fine beans.xml
    	 * 
    	 */
    	AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    	
    	/*
    	 * Recupera un bean avente id="helloWorld" nel file di configurazione beans.xml
    	 * 
    	 */
    	HelloWorld hw = (HelloWorld) context.getBean("helloWorld");
    	
    	/*
    	 * Recupera il messaggio contenuto nell'oggetto hw
    	 * 
    	 */
    	System.out.println("Messaggio: " + hw.getMessage());
    	
    	/*
    	 * Esegue lo shutdown dell'applicazione: registra un "gancio" all'evento
    	 * di shutdown della JVM e prima che tale evento si verifichi esegue lo
    	 * shutdown del contesto dell'applicazione distruggendo tutti i bean
    	 * dell'applicazione e rilasciando lo spazio in memoria prima che si
    	 * verifichi lo shutdown della JVM
    	 * 
    	 */
    	context.registerShutdownHook();
    }
}
