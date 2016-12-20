/* vim:set ts=4 sw=4: */
/**
 *
 * @author aculnaig
 *
 */

package com.gianluca.CDPlayer;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
//@Import({CDPlayerConfig.class, CDConfig.class})
@Import(CDPlayerConfig.class)
@ImportResource("cd-config.xml")
public class MainConfig {}

