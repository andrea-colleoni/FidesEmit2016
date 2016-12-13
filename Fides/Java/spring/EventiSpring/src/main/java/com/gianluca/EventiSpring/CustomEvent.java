/**
 *
 * @author aculnaig
 *
 */

package com.gianluca.EventiSpring;

import org.springframework.context.ApplicationEvent;

/*
 * Classe che rappresenta un evento personalizzato.
 * Estende la classe ApplicationEvent 
 *
 */

public class CustomEvent extends ApplicationEvent {

    // Costruttore
    public CustomEvent(Object source) {
	super(source);
    }

    @Override
    public String toString() {
	return "Evento personalizzato";
    }
}
