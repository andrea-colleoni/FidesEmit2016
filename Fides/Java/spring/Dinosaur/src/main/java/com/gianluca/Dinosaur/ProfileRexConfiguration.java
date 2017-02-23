/* vim:set ts=4 sw=4: */
/**
 * 
 * @author aculnaig
 * 
 */

package com.gianluca.Dinosaur;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("rex")
public class ProfileRexConfiguration {
	
	@Bean
	public Dinosaur rex() {
		Rex rex = new Rex();
		rex.setAltezza(13.0);
		rex.setPeso(300.0);
		
		return rex;
	}

}
