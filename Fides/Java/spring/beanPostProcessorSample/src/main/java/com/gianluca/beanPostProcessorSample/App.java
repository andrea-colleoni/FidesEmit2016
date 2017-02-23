package com.gianluca.beanPostProcessorSample;

/**
 * Hello world!
 *
 */

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        
        SampleBean obj = (SampleBean) context.getBean("sampleBean");
        
        System.out.println("Message: " + obj.getMessage());
        
        context.registerShutdownHook();
    }
}
