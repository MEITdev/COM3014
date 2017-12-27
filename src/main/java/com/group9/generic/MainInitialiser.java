package com.group9.generic;

import com.group9.config.RootConfig;
import com.group9.config.WebConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;


public class MainInitialiser implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext sc) throws ServletException {

        // ROOT
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(RootConfig.class);

        sc.addListener(new ContextLoaderListener(rootContext));

        // MVC
        AnnotationConfigWebApplicationContext mvcContext = new AnnotationConfigWebApplicationContext();
        mvcContext.register(WebConfig.class);

        // Map all requests ("/") to Spring via the DispacherServlet
        ServletRegistration.Dynamic dispatcherServlet = sc.addServlet("appServlet", new DispatcherServlet(mvcContext));
        dispatcherServlet.setLoadOnStartup(1);
        dispatcherServlet.addMapping("/");
    }

}
