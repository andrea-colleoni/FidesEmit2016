/* vim:set ts=4 sw=4 */
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



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={ProfileDevConfiguration.class, ProfileProdConfiguration.class})
@ActiveProfiles("prod")
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
