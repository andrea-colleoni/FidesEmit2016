/**
 *
 * @author aculnaig
 *
 */

package com.gianluca.BeanAutowireQualifier;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App {
    public static void main( String[] args ) {
	
    /* Crea il contesto in base alle impostazioni dell'applicazione
     * definite nel file beans.xml */
    ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

    /* Recupera un bean avete id="profile" nel file di configurazione beans.xml */
    Profile profile = (Profile) context.getBean("profile");

    profile.printNome();
    profile.printEta();
    }
}
