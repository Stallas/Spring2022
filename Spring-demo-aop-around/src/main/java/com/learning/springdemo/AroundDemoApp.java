package com.learning.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.learning.springdemo.service.FortunrTrafficService;

public class AroundDemoApp {

	public static void main(String[] args) {
		
		//read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoAppConfig.class);
		
		//get the bean from Spring container
		FortunrTrafficService service = context.getBean("fortunrTrafficService", FortunrTrafficService.class);
		
		String data = service.getFortune();
		
		System.out.println("My fortune is: "+data);
		
		//close the context
		context.close();
	}
}
