package com.gianluca.EreditarietaBean;

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
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        
        Padre p = (Padre) context.getBean("padre");
        
        System.out.println("Messaggio: " + p.getMessage1());
        System.out.println("Messaggio: " + p.getMessage2());
        
        Figlio f = (Figlio) context.getBean("figlio");
        
        System.out.println("Messaggio: " + f.getMessage1()); // Override
        System.out.println("Messaggio: " + f.getMessage2()); // Ereditato da Padre
        System.out.println("Messaggio: " + f.getMessage3()); // Nuova proprietà
    }
}
