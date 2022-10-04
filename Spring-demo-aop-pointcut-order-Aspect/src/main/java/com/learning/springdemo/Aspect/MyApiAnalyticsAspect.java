package com.learning.springdemo.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiAnalyticsAspect {

	@Before("com.learning.springdemo.Aspect.DemoAopExpressions.forDaoPackageNoSetterGetter()")
	public void performApiAnalytice() {
		System.out.println("Performing API Analytics");
	}
	
}
