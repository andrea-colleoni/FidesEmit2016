/* vim:set ts=4 sw=4: */
/**
 *
 * @author aculnaig
 * 
 */

package com.gianluca.CDPlayer;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/* Test di verifica se un CompactDisc e' stato trovato automaticamente dallo scanning dei componenti */

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes=CDPlayerConfig.class)
@ContextConfiguration(classes=MainConfig.class)
//@ContextConfiguration("beans.xml")
public class CDPlayerTest {

    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();

    @Autowired
    private MediaPlayer player;

    @Autowired
    private CompactDisc cd;

    @Test
    public void cdShouldNotBeNull() {
	assertNotNull(cd);
    }

    @Test
    public void play() {
	
	player.play();
	assertEquals("Playing Sgt. Pepper's Lonely Hearts Club Band by The Beatles\n", log.getLog());
    }
}

