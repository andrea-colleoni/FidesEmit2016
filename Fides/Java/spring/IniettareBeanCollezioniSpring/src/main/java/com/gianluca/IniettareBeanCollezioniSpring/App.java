package com.gianluca.IniettareBeanCollezioniSpring;

/**
 * @author aculnaig
 *
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        /* Creo il contesto */
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
 
        /* Recupero il bean 'collezione' */
        Collezione c = (Collezione) context.getBean("collezione");
 
        c.getAddressList();
 
        Indirizzo address1 = (Indirizzo) c.getAddressList().get(0);
        System.out.println("Via: " + address1.getVia() + "\nNumero Civico: " + address1.getCivico());

    }
}
