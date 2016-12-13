/**
 *
 * @author aculnaig
 *
 */

package com.gianluca.EventiSpring;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

/*
 * Classe che si occupa di pubblicare gli eventi custom 
 *
 * Deve implementare l'interfaccia ApplicationEventPublisherAware
 * che è l'interfaccia che deve essere implementata da ogni oggetto
 * che desidera essere informato all'ApplicationEventPublisher
 * (tipicamente l'ApplicationContext) che ci gira.
 *
 */

public class CustomEventPublisher implements ApplicationEventPublisherAware {
    
    /*
     * Interfaccia che incapsula la funzionalità di pubblicazione degli eventi.
     * Serve come super-interfaccia per ApplicationContext.
     *
     */
    private ApplicationEventPublisher publisher;

    /*
     * Inietta l'ApplicationEventPublisher mediante iniezione della dipendenza
     * realizzata mediante metodo Setter
     *
     */
    public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }
    
    // Metodo di pubblicazione dell'evento
    public void publish() {
	// Crea un nuovo CustomEvent
	CustomEvent ce = new CustomEvent(this); 

	// Lo pubblica tramite l'oggetto publisher
	publisher.publishEvent(ce);
    }

}
