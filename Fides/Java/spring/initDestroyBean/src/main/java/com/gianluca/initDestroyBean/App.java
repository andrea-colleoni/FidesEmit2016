package com.gianluca.initDestroyBean;

/**
 * 
 * @author aculnaig
 *
 */  

package com.gianluca.initDestroyBean;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App {
    public static void main( String[] args ) {
        
	AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        
        SampleBean obj = (SampleBean) context.getBean("initDestroyBean");
        
        System.out.println("Messaggio: " + obj.getMessage());
        
        /* Esegue lo shutdown dell'applicazione: registra un 'gancio'
         * all'evento di shutdown della JVM e prima che tale evento 
         * si verifichi esegue lo shutdown del contesto dell'applicazione 
         * distruggendo tutti i bean dell'applicazione e rilasciando
         * lo spazio in memoria prima che si verifichi lo shutdown della JVM */
        context.registerShutdownHook();
    }
}
