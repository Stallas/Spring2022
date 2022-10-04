package com.learning.springdemo;

import java.util.logging.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.learning.springdemo.service.FortunrTrafficService;

public class AroundHandleExceptionDemoApp {

	//Using Logger to print everything in stream.
	private static Logger logger = Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());
			
	public static void main(String[] args) {
		
		//read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoAppConfig.class);
		
		//get the bean from Spring container
		FortunrTrafficService service = context.getBean("fortunrTrafficService", FortunrTrafficService.class);
		
		boolean flag = true;
		String data = service.getFortune(flag);
		
		logger.info("My fortune is: "+data);
		
		logger.info("Finished");
		//close the context
		context.close();
	}
}
