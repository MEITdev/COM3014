
package com.group9.config;

import java.util.Arrays;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 *
 * @author bogdan
 */
@Configuration
@EnableWebMvc
@ComponentScan({"com.group9.*"})
@Import({AppProperties.class})
public class WebConfig extends WebMvcConfigurerAdapter {

    //private static final Logger LOGGER = LoggerFactory.getLogger(WebConfig.class);
    public WebConfig() {
        //LOGGER.info("WebConfig() init");
    }

    /**
     * Setup a simple strategy: use all the defaults and return JSON by default
     * when not sure.
     *
     * @param configurer
     */
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.defaultContentType(MediaType.APPLICATION_JSON).
                mediaType("html", MediaType.TEXT_HTML).
                mediaType("xml", MediaType.APPLICATION_XML).
                mediaType("json", MediaType.APPLICATION_JSON);
    }

    /**
     * By default MANY HttpMessageConverters instances are pre-enabled (inc
     * MappingJackson2HttpMessageConverter)! But for the sake of allowing it to
     * configure it further, here is the method to do so
     *
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

        converters.add(new MappingJackson2HttpMessageConverter());
        // you can add more conferters if you want

        super.configureMessageConverters(converters);
    }

    /**
     * This sets the location of the resources of the application such as JS or
     * CSS or images
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
        registry.addResourceHandler("/css/**").addResourceLocations("classpath:/css/");
        registry.addResourceHandler("/img/**").addResourceLocations("classpath:/img/");
        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/js/");
    }

    /**
     * It tells Spring to use the container's default servlet for certain
     * requests, like for static resources. Not needed for REST only apps
     * (usually)
     *
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /**
     * I only setup this to allow for the hello view to work! So this method can
     * be deleted if you have no Views
     *
     * @return
     * @throws Exception
     */
    @Bean
    public ContentNegotiatingViewResolver contentViewResolver() throws Exception {
        //LOGGER.debug("contentViewResolver() init");

        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");

        List<ViewResolver> listOfResolvers = Arrays.<ViewResolver>asList(viewResolver);
        
        ContentNegotiatingViewResolver contentViewResolver = new ContentNegotiatingViewResolver();
        contentViewResolver.setViewResolvers(listOfResolvers);
        return contentViewResolver;
    }

    /**
     * This is to just set the default view to hello. This can also be deleted if there are no views
     *
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("redirect:login.jsp"); // if you dont put "redirect:" it will resolve the view without going in the controller!!!
    }
    
}
