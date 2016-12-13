/**
 *
 * @author aculnaig
 *
 */

package com.gianluca.BeanAutowireQualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/*
 * Classe in cui viene iniettato un solo specifico bean
 * avente tipo Studente, tra quelli dichiarati
 * nel file di configurazione beans.xml
 *
 */

public class Profile {

    /*
     * Proprietà in cui inietto uno specifico bean di tipo Studente
     * tramite @Autowire e uso @Qualifier per specificare l'esatto
     * bean da iniettare
     *
     */

    @Autowired
    @Qualifier("studente1")
    private Studente studente;

    /* Costruttore */
    public Profile() {
	System.out.println("All'interno del costruttore Profile()");
    }

    /* Metodi di output sullo specifico bean iniettato */
    public void printEta() {
	System.out.println("Età: " + studente.getEta());
    }

    public void printNome() {
	System.out.println("Nome: " + studente.getNome());
    }
    
}
