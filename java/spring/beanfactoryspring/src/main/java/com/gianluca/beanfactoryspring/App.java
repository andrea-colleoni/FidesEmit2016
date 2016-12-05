package com.gianluca.beanfactoryspring;

/**
 * Hello world!
 *
 */
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
    	ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");
    	
    	// Casting di appContext dato che una ApplicationContext è una BeanFactory
        BeanFactory factory = (BeanFactory) appContext;
        
        HelloWorld obj = (HelloWorld) factory.getBean("helloWorld");
        System.out.println("Messaggio: " + obj.getMessage());
    }
}
