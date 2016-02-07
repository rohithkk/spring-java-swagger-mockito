package com.rohith.library.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * To initialize a Spring MVC web app without the web.xml file, we need to implement the
 * WebApplicationInitializer interface.
 * 
 * There is a new and preferred way to do this now - instead of implementing WebApplicationInitializer interface,
 * we can extend AbstractAnnotationConfigDispatcherServletInitializer which provides some of the default functionality.
 * 
 * 
 * @author rohith
 * @see LibraryAppWebInitializer
 */
//implements WebApplicationInitializer
public class LibraryAppWebInitializerOldWay {

	public void onStartup(ServletContext sc) throws ServletException {
		
		try (AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext()){
			ctx.register(LibraryAppSpringConfiguration.class);
			ctx.setServletContext(sc);
			
			ServletRegistration.Dynamic servlet = sc.addServlet("dispatcher", new DispatcherServlet());
			
			servlet.setLoadOnStartup(1);
			servlet.addMapping("/");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
