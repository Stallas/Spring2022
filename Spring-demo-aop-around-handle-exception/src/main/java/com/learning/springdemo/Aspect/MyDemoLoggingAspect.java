package com.learning.springdemo.Aspect;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.learning.springdemo.AroundHandleExceptionDemoApp;

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
		Object result = null;
		
		/* Main App doesn't know the exception occurred as it is caught here unless rethrown*/
		try {
			result = pjp.proceed();
		} catch (Throwable e) {
			//log the message
			logger.warning(e.getMessage());
			
			//give a custom message
			/* uncomment this to handle exception*/
			//result = "Major accident but no worries as exception are caught in Aspect";
			
			// to rethrow the exception to MainApp
			throw e;
		}
		
		// get end timestamp
		long end = System.currentTimeMillis();
		
		// instrumentation i.e. duration of code
		long duration = end-start;

		logger.info("duration : "+duration);
		return result;
	}
	

		
		
		
		


}
