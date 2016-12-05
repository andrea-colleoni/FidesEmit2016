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
        
        HelloWorld objA = (HelloWorld) context.getBean("helloWorld");
        
        System.out.println("Messaggio: " + objA.getMessage1());
        System.out.println("Messaggio: " + objA.getMessage2());
        
        HelloItalia objB = (HelloItalia) context.getBean("helloItalia");
        
        System.out.println("Messaggio: " + objB.getMessage1()); // Override
        System.out.println("Messaggio: " + objB.getMessage2()); // Ereditato da HelloWorld
        System.out.println("Messaggio: " + objB.getMessage3()); // Nuova proprietà
    }
}
