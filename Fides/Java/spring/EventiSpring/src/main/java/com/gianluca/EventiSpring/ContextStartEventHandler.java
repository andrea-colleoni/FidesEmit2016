/**
 * 
 * @author aculnaig
 * 
 */

package com.gianluca.EventiSpring;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;

/* 
 * Classe che implementa l'interfaccia ApplicationListener
 * per la gestione dell'evento ContextStartedEvent
 * che si verifica quando il contesto viene avviato
 * medinate il metodo start() 
 * 
 */

public class ContextStartEventHandler implements ApplicationListener<ContextStartedEvent> {
	
	// Metodo che gestisce l'evento ContextStartedEvent
	public void onApplicationEvent(ContextStartedEvent event) {
		System.out.println("ContextStartedEvent ricevuto.");
	}

}
