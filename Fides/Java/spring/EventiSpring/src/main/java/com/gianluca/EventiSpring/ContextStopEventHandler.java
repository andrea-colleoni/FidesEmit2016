/**
 * 
 * @author aculnaig
 * 
 */

package com.gianluca.EventiSpring;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStoppedEvent;

/* 
 * Classe che implementa l'interfaccia ApplicationListener
 * per la gestione dell'evento ContextStoppedEvent
 * che si verifica quando il contesto viene terminato
 * mediante il metodo stop()
 * 
 */

public class ContextStopEventHandler implements ApplicationListener<ContextStoppedEvent> {
	
	// Metodo che gestisce l'evento ContextStoppedEvent
	public void onApplicationEvent(ContextStoppedEvent event) {
		System.out.println("ContextStoppedEvent ricevuto.");
	}

}
