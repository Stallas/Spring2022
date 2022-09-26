package com.learning.SpringBootCore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringBootDemoApplication.class, args);
		System.out.println("Hello !! welcome to Spring Boot");

		// 1.Spring container checks the classes annotated with @Component and
		// initializes all the beans.
		// Else, NoSuchBeanException is thrown when getbean is invoked.

		// 2.Since default scope is Singleton, only once the bean is initialized.
		// 3. If Scope is Prototype, new instance is created for each getbean
		// invocation. If we comment the getbean method, then bean not initialized for
		// prototype.
		Alien a = context.getBean(Alien.class);// The object gets created without invoking getbean for Alien class as it
												// annotated with @Component.
		//Alien a1 = context.getBean(Alien.class);
		a.display();

	}

}
