/**
 * @author aculnaig
 *
 */

package com.gianluca.AnnotationConfigurationBean;

import org.springframework.context.annotation.*;

/* 
 * Classe annotata con @Configuration: la classe può essere usata dallo
 * IoC Container di Spring come sorgente di definizione dei bean 
 * 
 */

@Configuration
public class HelloWorldConfig {
	
	/* 
	 * Metodo annotato con @Bean che restituisce un oggetto HelloWorld
	 * da inserire nell'application context di Spring 
	 * 
	 */
	
	@Bean
	public HelloWorld helloWorld() {
		return new HelloWorld();
	}

}
