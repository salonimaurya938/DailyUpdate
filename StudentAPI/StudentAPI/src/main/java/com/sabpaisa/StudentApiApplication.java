package com.sabpaisa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@EnableSpringHttpSession()
//@ComponentScan(basePackages = "com.sabpaisa.*")
public class StudentApiApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(StudentApiApplication.class, args);
		System.out.println("Start Student API...");
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(StudentApiApplication.class);
	}

}
