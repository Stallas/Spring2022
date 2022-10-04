package com.learning.springdemo.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {

	/*
	 * @After --> Acts like finally block
	 * 
	 * Runs afterthrowing && afterReturning advices65  
	 * 
	 */
	@After("execution(* com.learning.springdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsMethod(JoinPoint joinpoint) {

		// print out which method we are advising on
		String method = joinpoint.getSignature().toShortString();
		System.out.println("Executing @AfterFinally on method: " + method);

	}
	
	@AfterThrowing(pointcut = "execution(* com.learning.springdemo.dao.AccountDAO.findAccounts(..))", throwing = "theExc")
	public void afterThrowingFindAccountsMethod(JoinPoint joinpoint, Throwable theExc) {

		// print out which method we are advising on
		String method = joinpoint.getSignature().toShortString();
		System.out.println("Executing @AfterThrowing on method: " + method);

		// Log the exception
		System.out.println("Log Exception:  " + theExc);
		
	}

		
		
		
		


}
