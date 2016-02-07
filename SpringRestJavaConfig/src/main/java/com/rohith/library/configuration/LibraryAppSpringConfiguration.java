package com.rohith.library.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 *  LibraryAppSpringConfiguration is the Spring configuration class.
 *  
 *  EnableWebMVC annotation is equivalent to <mvc:annotation-driven/> tag in XML based configuration.
 *  
 *  ComponentScan annotation is equivalent to <context:componentScan basePackages=""/> tag in XML based configuration.
 *  
 *  
 * @author rohith
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.rohith.library")
public class LibraryAppSpringConfiguration extends WebMvcConfigurerAdapter{

	/**
	 * This method registers a view resolver.
	 * 
	 * @return
	 */
	@Bean
	public ViewResolver viewResolver()
	{
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
}
