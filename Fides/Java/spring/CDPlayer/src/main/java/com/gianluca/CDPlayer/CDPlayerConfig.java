/* vim:set ts=4 sw=4: */
/**
 *
 * @author aculnaig
 *
 */

package com.gianluca.CDPlayer;

import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


/* @Configuration indica che la classe � una classe di configurazione Spring */
/* @ComponentScan abilita lo scanning automatico dei componenti */

@Configuration
//@ComponentScan
public class CDPlayerConfig {

	// Dichiarare un Bean
	@Bean
	public CompactDisc sgtPeppers() {
		return new SgtPeppers();
	}

	/* Dichiare un Bean con un ID specifico 
	 * 
	 * @Bean(name="lonelyHeartsClubBand")
	 * public CompactDisc sgtPeppers() {
	 *     return new SgtPeppers();
	 * }
	 *
	 */

	/* Dichiare un Bean da una selezione randomizzata di CompactDisc
	 *
	 * @Bean
	 * public CompactDisc randomBeatlesCD() {
	 *     
	 *     int choice = (int) Math.floor(Math.random() * 4);
	 *     if (choice == 0)
	 *         return new SgtPeppers();
	 *
	 *     else if(choice == 1)
	 *         return new WhiteAlbum();
	 *
	 *     else if(choice == 2)
	 *         return new HardDaysNight();
	 *
	 *     else
	 *         return new Revolver();
	 */

	/* Il bean cdPlayer fa riferimento direttamente al bean sgtPeppers */
    @Bean
	public CDPlayer cdPlayer() {   
		return new CDPlayer(sgtPeppers());
	}

	/* Il bean cdPlayer non fa riferimento direttamente al bean sgtPeppers
	 * ma ha un parametro CompactDisc e si affida all'autowiring di Spring
	 * per l'iniezione del bean corretto
	 *
	 * @Bean
	 * public CDPlayer cdPlayer(CompactDisc compactDisc) {
	 *     return new CDPlayer(compactDisc);
	 *
	 * }
	 *
	 * All'atto della creazione di un bean � possibile compiere
	 * l'iniezione delle dipendenze senza l'utilizzo
	 * del costruttore della classe del bean, ma anche tramite
	 * il suo metodo setter
	 *
	 * @Bean
	 * public CDPlayer cdPlayer(CompactDisc compactDisc) {
	 *     CDPlayer cdPlayer = new CDPlayer(compactDisc);
	 *     cdPlayer.setCompactDisc(compactDisc);
	 *     return cdPlayer;
	 * }
	 *
	 */
}
