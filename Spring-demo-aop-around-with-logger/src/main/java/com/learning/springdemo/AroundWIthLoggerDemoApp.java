package com.learning.springdemo;

import java.util.logging.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.learning.springdemo.service.FortunrTrafficService;

public class AroundWIthLoggerDemoApp {

	//Using Logger to print everything in stream.
	private static Logger logger = Logger.getLogger(AroundWIthLoggerDemoApp.class.getName());
			
	public static void main(String[] args) {
		
		//read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoAppConfig.class);
		
		//get the bean from Spring container
		FortunrTrafficService service = context.getBean("fortunrTrafficService", FortunrTrafficService.class);
		
		String data = service.getFortune();
		
		logger.info("My fortune is: "+data);
		
		logger.info("Finished");
		//close the context
		context.close();
	}
}
