/* vim:set ts=4 sw=4: */
/**
 * 
 * @author aculnaig
 * 
 */

package com.gianluca.AccountSample;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    
	public static void main(String[] args) {
    
		/* 
		 * Configurazione del contesto tramite Java
	     * AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(AccountSampleBeansConfiguration.class);
	     *
	     */
	    
		/*
		 * Configurazione tramite file XML
		 */
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("com/gianluca/AccountSample/beans.xml");
		 

		/*
		 * Configurazione tramite Java annotations
		 * ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("com/gianluca/AccountSample/beans2.xml");
		 *
		 */
		
	    AccountService as = appContext.getBean("accountServiceImplementation", AccountService.class);
	
	    System.out.println("Before money transfer");
	    System.out.println(String.format("Account[%d, %s, %.1f]", as.getAccount(1).getId(), as.getAccount(1).getOwnerName(),as.getAccount(1).getBalance()));
	    System.out.println(String.format("Account[%d, %s, %.1f]", as.getAccount(2).getId(), as.getAccount(2).getOwnerName(),as.getAccount(2).getBalance()));
	
	    as.transferMoney(1, 2, 500.0);
	
	    System.out.println("After money transfer");
	    System.out.println(String.format("Account[%d, %s, %.1f]", as.getAccount(1).getId(), as.getAccount(1).getOwnerName(),as.getAccount(1).getBalance()));
	    System.out.println(String.format("Account[%d, %s, %.1f]", as.getAccount(2).getId(), as.getAccount(2).getOwnerName(),as.getAccount(2).getBalance()));

    }
}
