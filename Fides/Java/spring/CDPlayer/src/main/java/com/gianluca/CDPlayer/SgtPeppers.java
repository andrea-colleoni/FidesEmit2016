/* vim:set ts=4 sw=4: */
/**
 *
 * @author aculnaig
 *
 */

package com.gianluca.CDPlayer;

import org.springframework.stereotype.Component;

/* SgtPeppers e' una classe pubblica che implementa l'interfaccia CompactDisc */

@Component
public class SgtPeppers implements CompactDisc {

	private String title = "Sgt. Pepper's Lonely Hearts Club Band";
	private String artist = "The Beatles";

    public void play() {
	    System.out.print(String.format("Playing %s by %s\n", title, artist));
    	//System.out.print("Playing " + title + " by " + artist);
	}
}
