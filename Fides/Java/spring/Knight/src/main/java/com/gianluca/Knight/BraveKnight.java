/* vim:set ts=4 sw=4: */
/**
 *
 * @author aculnaig
 *
 */

package com.gianluca.Knight;

import org.springframework.beans.factory.DisposableBean;

public class BraveKnight implements Knight, DisposableBean {

	private Quest quest;
	private Minstrel minstrel;

	public BraveKnight(Quest quest, Minstrel minstrel) {
	    this.quest = quest;
	    this.minstrel = minstrel;
	}

    public void embarkOnQuest() {
    	minstrel.singBeforeQuest();
	    quest.embark();
	    minstrel.singAfterQuest();
	}

	public void destroy() throws Exception {
    	System.out.println(String.format("%s ha implementato l'interfaccia %s\nChiamata a destroy", 
    									 BraveKnight.class.getSimpleName(),
    									 DisposableBean.class.getSimpleName()));
	}
}
