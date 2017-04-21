package com.api.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import com.mangofactory.swagger.plugin.EnableSwagger;

@Configuration
@EnableSwagger
public class MvcConfiguration extends WebMvcConfigurerAdapter{
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {		
		registry.addViewController("/swapi").setViewName("swagger");		
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/401").setViewName("error/401");
		registry.addViewController("/access-denied").setViewName("error/access-denied");
	}
	
	@Override	
	public void addResourceHandlers(ResourceHandlerRegistry registry) {		
		registry.addResourceHandler("/images/**").addResourceLocations("file:///Users/sokchanny/Documents/Projects/Springs/API_4_TEST/upload-files/");
	}
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedMethods("GET","POST","DELETE","PUT","OPTIONS","PATCH")
				.allowedOrigins("*");
	}
}
