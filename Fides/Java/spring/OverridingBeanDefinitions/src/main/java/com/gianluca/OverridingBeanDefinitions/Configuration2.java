/* vim:set ts=4 sw=4: */
/**
 *
 * @author aculnaig
 *
 */

package com.gianluca.OverridingBeanDefinitions;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configuration2 {

    @Bean
    public Foo foo() {
        
		Foo foo = new Foo();
		foo.setName("your Foo");
		return foo;
    }

}
