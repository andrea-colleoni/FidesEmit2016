/* vim:set ts=4 sw=4: */
/**
 *
 * @author aculnaig
 *
 */

package com.gianluca.Knight;

public class BraveKnight {

	private Quest quest;

	public BraveKnight(Quest quest) {
	    this.quest = quest;
	}

    public void embarkOnQuest() {
	    quest.embark();
	}
}
