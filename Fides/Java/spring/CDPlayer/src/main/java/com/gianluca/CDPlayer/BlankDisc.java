/* vim:set ts=4 sw=4: */
/**
 *
 * @author aculnaig
 *
 */

package com.gianluca.CDPlayer;

import org.springframework.stereotype.Component;
import java.util.List;

/* BlankDisc e' una classe pubblica che implementa l'interfaccia CompactDisc */

@Component
public class BlankDisc implements CompactDisc {

	private String title;
	private String artist;
    private List<String> tracks;

	public BlankDisc(String title, String artist, List<String> tracks) {
		this.title = title;
		this.artist = artist;
		this.tracks = tracks;
	}

    public void play() {
	    System.out.print(String.format("Playing %s by %s", title, artist));
    	//System.out.print("Playing " + title + " by " + artist);
		for (String track : tracks)
			System.out.print(String.format("-Track: %s\n", track));
	}
}
