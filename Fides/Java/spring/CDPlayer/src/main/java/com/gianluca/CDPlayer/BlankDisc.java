/* vim:set ts=4 sw=4: */
/**
 *
 * @author aculnaig
 *
 */

package com.gianluca.CDPlayer;

import org.springframework.stereotype.Component;

/* BlankDisc è una classe pubblica che implementa l'interfaccia CompactDisc */

@Component
public class BlankDisc implements CompactDisc {

	private String title;
	private String artist;

	public BlankDisc(String title, String artist) {
		this.title = title;
		this.artist = artist;
	}

    public void play() {
	    System.out.print(String.format("Playing %s by %s", title, artist));
    	//System.out.print("Playing " + title + " by " + artist);
	}
}
