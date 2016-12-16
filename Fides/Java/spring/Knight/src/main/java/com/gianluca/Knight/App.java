/* vim:set ts=4 sw=4: */
/**
 *
 * @author aculnaig
 *
 */

package com.gianluca.Knight;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) throws Exception {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("knights.xml");
		BraveKnight knight = context.getBean(BraveKnight.class);
		
		knight.embarkOnQuest();
		context.close();
	}

}
