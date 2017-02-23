package com.gianluca.InnerBeanSpring;

/**
 * 
 * @author aculnaig
 * 
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    	
    	TextEditor te = (TextEditor) context.getBean("outerBean");
    	
    	te.spellChecking();
    }
}
