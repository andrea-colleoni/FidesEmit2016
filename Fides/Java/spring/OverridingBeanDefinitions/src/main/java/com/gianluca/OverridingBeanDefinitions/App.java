/* vim:set ts=4 sw=4: */
/**
 * 
 * @author aculnaig
 * 
 */

package com.gianluca.OverridingBeanDefinitions;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    
	public static void main(String[] args) {
    
		/* 
		 * Configurazione del contesto tramite Java
	     */
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(Configuration1.class, Configuration2.class);
		Foo foo = appContext.getBean(Foo.class);
		System.out.println(foo.getName());
		
		appContext = new AnnotationConfigApplicationContext(Configuration2.class, Configuration1.class);
		Foo foo2 = appContext.getBean(Foo.class);
		System.out.println(foo2.getName());
		
		
	}
}
