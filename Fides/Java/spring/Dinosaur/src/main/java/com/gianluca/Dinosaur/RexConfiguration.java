/* vim:set ts=4 sw=4 */
/**
 * 
 * @author aculnaig
 * 
 */

package com.gianluca.Dinosaur;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class RexConfiguration {
	
	@Bean
	public Dinosaur rex() {
		Rex rex = new Rex();
		rex.setAltezza(13.0);
		rex.setPeso(300.0);
		
		return rex;
	}

}
