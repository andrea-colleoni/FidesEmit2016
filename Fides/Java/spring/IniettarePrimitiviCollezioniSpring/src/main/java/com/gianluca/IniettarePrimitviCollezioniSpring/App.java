package com.gianluca.IniettarePrimitviCollezioniSpring;

/**
 * 
 * @author aculnaig
 *
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
    	// Creo il context per recupare i bean
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        
        // Recupero il bean
        Collezione c = (Collezione) context.getBean("collezione");
        
        // Recupero le collezioni
        c.getAddressList();
        c.getAddressSet();
        c.getAddressMap();
        c.getAddressProp();
    }
}
