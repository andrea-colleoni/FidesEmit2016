/* vim:set ts=4 sw=4: */
/** 
 *
 * @author aculnaig
 *
 */

package com.gianluca.Knight;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KnightConfig {

    @Bean
    public BraveKnight knight() {
        return new BraveKnight(quest());
    }

    @Bean
    public Quest quest() {
        return new SlayDragonQuest(System.out);
    }
}

