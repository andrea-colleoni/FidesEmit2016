/**
 *
 * @author aculnaig
 *
 */

package com.gianluca.EventiSpring;

import org.springframework.context.ApplicationListener;

/*
 * Classe che implementa l'interfaccia ApplicationListener
 * per la gestione dell'evento personalizzato CustomEvent 
 *
 */

public class CustomEventHandler implements ApplicationListener<CustomEvent> {

    // Metodo che gestisce l'evento personalizzato
    public void onApplicationEvent(CustomEvent event) {
	System.out.println(event.toString());
    }
}
