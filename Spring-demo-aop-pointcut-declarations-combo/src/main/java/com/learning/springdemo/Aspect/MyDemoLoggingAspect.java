package com.learning.springdemo.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	/*
	 * How to combine pointcut expressions?
	 * 
	 * Create a Pointcut declaration Combine a Pointcut declaration Apply Pointcut
	 * declaration to all advices
	 */
	@Pointcut("execution(* com.learning.springdemo.dao.*.*(..))")
	private void forDaoPackage() {

	}
	
	// create point cut for getter methods
	@Pointcut("execution(* com.learning.springdemo.dao.*.get*(..))")
	private void getter() {

	}
	// create point cut for setter methods
	@Pointcut("execution(* com.learning.springdemo.dao.*.set*(..))")
	private void setter() {

	}
	// create point cut : include package...exclude getter/setter methods
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void combinedPointcut() {
		
	}
	
	@Before("combinedPointcut()")
	public void performApiAnalytice() {
		System.out.println("Performing API Analytics");
	}
}
