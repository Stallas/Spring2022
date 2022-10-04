package com.learning.springdemo.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {

	/*
	 * How to control the order of advice being applied
	 * 
	 * Refractor: Place advice in separate aspects control the order by @Order and
	 * guarantees the order.
	 * 
	 * (Have all advices defined in a DemoAopExpressions class and place them in
	 * separate aspects for order 
	 * ORDER:
	 * 		 Range: INTEGER.MIN_VALUE to INTEGER.MAX_VALUE,
	 * 		 Negative nos allowed,
	 * 		 Need not be consecutive numbers
	 * 		 if both advices have same order, then order is undefined in random fashion
	 */

	@Before("com.learning.springdemo.Aspect.DemoAopExpressions.forDaoPackageNoSetterGetter()")
	public void beforeAdviceMethod() {
		System.out.println("\n>>>>> Executing @Before Advice");
	}

}
