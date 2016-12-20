/* vim: ts=4 sw=4: */
/**
 *
 * @author aculnaig
 *
 */

package com.gianluca.CDPlayer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CDConfig {

    @Bean
    public CompactDisc compactDisc() {
	return new SgtPeppers();
    }
}
