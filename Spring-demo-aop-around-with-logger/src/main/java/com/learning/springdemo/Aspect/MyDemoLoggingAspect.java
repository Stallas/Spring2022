package com.learning.springdemo.Aspect;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.learning.springdemo.AroundWIthLoggerDemoApp;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {

	/*
	 * @Around --> Acts like finally block
	 * 
	 * Runs afterthrowing && afterReturning advices65  
	 * 
	 */
	private static Logger logger = Logger.getLogger(MyDemoLoggingAspect.class.getName());
	@Around("execution(* com.learning.springdemo.service.*.getFortune(..))")
	public Object aroundgetFortune(ProceedingJoinPoint pjp) throws Throwable {

		// print out which method we are advising on
		String method = pjp.getSignature().toShortString();
		logger.info("Executing @Around on method: " + method);	
		
		//get begin timesstamp
		long start = System.currentTimeMillis();
		
		//execute the method
		Object result = pjp.proceed();
		
		// get end timestamp
		long end = System.currentTimeMillis();
		
		// instrumentation i.e. duration of code
		long duration = end-start;

		logger.info("duration : "+duration);
		return result;
	}
	

		
		
		
		


}
