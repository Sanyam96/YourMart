package com.nagarro.yourmart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class YourmartApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(YourmartApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(YourmartApplication.class, args);
//		System.out.println("Hello World!");
	}
}
