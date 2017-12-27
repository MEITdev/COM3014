
package com.group9.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;

/**
 *
 * @author bogdan
 */
@Configuration
// Scan all components, but dont scan (i.e. filter out) the classes that are annotated as @Controllers. This is scanned separatelly in WebConfig
@ComponentScan(value = {"com.group9"}, excludeFilters = {@ComponentScan.Filter(Controller.class)})
@Import({AppProperties.class} )
public class RootConfig {
    
}
