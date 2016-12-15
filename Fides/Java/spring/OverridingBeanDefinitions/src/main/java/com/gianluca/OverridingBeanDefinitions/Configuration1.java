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
public class Configuration1 {

    @Bean
    public Foo foo() {
        
		Foo foo = new Foo();
		foo.setName("my Foo");
		return foo;
    }

}
