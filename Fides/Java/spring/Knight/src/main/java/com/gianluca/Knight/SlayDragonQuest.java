/* vim:set ts=4 sw=4: */
/**
 *
 * @author aculnaig
 *
 */

package com.gianluca.Knight;

import java.io.PrintStream;

public class SlayDragonQuest implements Quest {

    private PrintStream stream;

	public SlayDragonQuest(PrintStream stream) {
	    this.stream = stream;
	}

    public void embark() {
	    System.out.println("Embark to slay the dragon!");
	}
}
