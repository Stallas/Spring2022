package com.learning.SpringBootWeb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MainApp {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MainApp.class, args);
		System.out.println("Hello !! welcome to Spring Boot");

	}

}
