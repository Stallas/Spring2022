package com.learning.springdemo.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
public class DemoAopExpressions {

	/*
	 * Declaring all Point cut expressions in a class and changing the modifier to
	 * Public so it can be reused.
	 */

	@Pointcut("execution(* com.learning.springdemo.dao.*.*(..))")
	public void forDaoPackage() {
	}

	// create point cut for getter methods
	@Pointcut("execution(* com.learning.springdemo.dao.*.get*(..))")
	public void getter() {
	}

	// create point cut for setter methods
	@Pointcut("execution(* com.learning.springdemo.dao.*.set*(..))")
	public void setter() {
	}

	// create point cut : include package...exclude getter/setter methods
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoSetterGetter() {
	}
}
