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
@Profile("sauro")
public class ProfileSauroConfiguration {
	
	@Bean
	public Dinosaur sauro() {
		Sauro sauro = new Sauro();
		sauro.setAltezza(16.0);
		sauro.setPeso(250.0);
		
		return sauro;
	}

}
