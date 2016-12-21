/* vim:set ts=4 sw=4: */
/**
 * 
 * @author aculnaig
 * 
 */

package com.gianluca.Dinosaur;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/* La classe DinosaurTest testa se il bean creato e' nullo e se il metodo roar va a buon fine
 *
 * La classe mostra anche l'utilizzo dell'annotazione @ActiveProfiles che e' un'annotazione a livello di classe (class-level),
 * la quale dichiara il profilo attualmente attivo all'interno del test e permette la creazione dei bean definiti in quel profilo.
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={ProfileRexConfiguration.class, ProfileSauroConfiguration.class})
//@ActiveProfiles("rex")
@ActiveProfiles("sauro")
public class DinosaurTest {

    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();
        
    @Autowired
    private Dinosaur d;

    @Test
    public void dShouldNotBeNull() {
        assertNotNull(d);
    }

    @Test
    public void roar() {
        d.roar();
    }

}
