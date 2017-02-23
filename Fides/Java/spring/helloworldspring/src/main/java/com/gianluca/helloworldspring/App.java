package com.gianluca.helloworldspring;

/**
 * Hello world!
 *
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        /* Crea il contesto in base alle impostazioni dell'applicazione
         * definite nel file beans.xml */
    	ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    	
    	/* Recupera un bean avente id='helloWorld' nel file di configurazione
    	 * beans.xml */
    	HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
    	
    	/* Invoco il metodo che stampa il messaggio su tale oggetto */
    	System.out.println("Messaggio: " + obj.getMessage());
    	
    	obj = (HelloWorld) context.getBean("moseca");
    	System.out.println("Messaggio: " + obj.getMessage());
    }
}
