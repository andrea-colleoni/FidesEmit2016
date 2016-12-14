/* vim:set ts=4 sw=4: */
/**
 * 
 * @author aculnaig
 * 
 */

package com.gianluca.AccountSample;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    
	public static void main( String[] args ) {
    
	    AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(AccountSampleBeansConfiguration.class);
	
	    AccountService as = appContext.getBean("accountService", AccountService.class);
	
	    System.out.println("Before money transfer");
	    System.out.println("Account 1 balance: " + as.getAccount(1).getBalance());
	    System.out.println("Account 2 balance: " + as.getAccount(2).getBalance());
	
	    as.transferMoney(1, 2, 500.0);
	
	    System.out.println("After money transfer");
	    System.out.println("Account 1 balance: " + as.getAccount(1).getBalance());
	    System.out.println("Account 2 balance: " + as.getAccount(2).getBalance());

    }
}
