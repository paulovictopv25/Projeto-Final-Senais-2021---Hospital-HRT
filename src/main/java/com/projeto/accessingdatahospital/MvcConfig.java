package com.projeto.accessingdatahospital;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/home").setViewName("home");
		registry.addViewController("/").setViewName("home");
		registry.addViewController("/hello").setViewName("hello");
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/manager").setViewName("manager");
		registry.addViewController("/css/signin.css").setViewName("css/signin.css");
		registry.addViewController("/img/governobrasilia.png").setViewName("img/governobrasilia.png");
	}

}