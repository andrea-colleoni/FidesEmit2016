/**
 * 
 */
package com.gianluca.beanPostProcessorSample;

/**
 * @author aculanig
 *
 */

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.BeansException;

public class BeanPPS implements BeanPostProcessor {
	
	// Metodo eseguito prima dell'inizializzazione del bean
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("Chiamato prima dell'inizializzazione di " + beanName);
		return bean;
	}
	
	// Metodo eseguito dopo dell'inizializzazione del bean
		public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
			System.out.println("Chiamato dopo l'inizializzazione di " + beanName);
			return bean;
		}

}
