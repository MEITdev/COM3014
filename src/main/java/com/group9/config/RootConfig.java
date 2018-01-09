
package com.group9.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;


@Configuration
//Scan components in main package
@ComponentScan(value = {"com.group9"}, excludeFilters = {@ComponentScan.Filter(Controller.class)})
@Import({AppProperties.class} )
public class RootConfig {
    
}
