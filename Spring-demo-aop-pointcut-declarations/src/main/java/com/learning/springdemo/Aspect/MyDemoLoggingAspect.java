package com.learning.springdemo.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	/*
	 * How can we reuse a pointcut expression ?want to apply it to multiple advices?
	 * 
	 * Possible Solns: 
	 * 1.copy/paste method
	 * 2.Create a point cut declaration and reusing the point cut Expression
	 */
	@Pointcut("execution(* com.learning.springdemo.dao.*.*(..))")
	private void forDaoPackage() {

	}

	@Before("forDaoPackage()")
	public void beforeAddAccountAdvice() {
		System.out.println("Match methods with param names");
	}

	@Before("forDaoPackage()")
	public void performApiAnalytice() {
		System.out.println("Performing API Analytics");
	}
	
}
