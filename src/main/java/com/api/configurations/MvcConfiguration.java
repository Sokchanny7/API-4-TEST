package com.api.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import com.mangofactory.swagger.plugin.EnableSwagger;

@Configuration
@EnableSwagger
public class MvcConfiguration extends WebMvcConfigurerAdapter{
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/test").setViewName("test");
		registry.addViewController("/swapi").setViewName("swagger");		
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/401").setViewName("error/401");
		registry.addViewController("/access-denied").setViewName("error/access-denied");
	}
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedMethods("GET","POST","DELETE","PUT","OPTIONS","PATCH")
				.allowedOrigins("*");
	}
}
