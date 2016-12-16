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

    	/* Cerca il file di configurazione dei bean per creare il contesto nella classpath dell'applicazione */
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("knights.xml");
		
		/* Ottiene il bean dal contesto */
		BraveKnight knight = context.getBean(BraveKnight.class);
		
		/* Il cavaliere si imbarca nella sua avventura */
		knight.embarkOnQuest();
		
		/* Il contesto non ci serve più, chiudiamolo */
		context.close();
	}

}
