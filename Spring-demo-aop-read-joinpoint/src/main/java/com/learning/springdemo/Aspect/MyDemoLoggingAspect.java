package com.learning.springdemo.Aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.learning.springdemo.entity.Account;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {

	/*
	 * How to access method parameters & method parameters?
	 * 
	 * JoinPoint --> gives metadata about the method call.
	 */

	@Before("com.learning.springdemo.Aspect.DemoAopExpressions.forDaoPackageNoSetterGetter()")
	public void beforeAdviceMethod(JoinPoint joinpoint) {
		
		System.out.println("\n>>>>> Executing @Before Advice");
		
		//displaying the method signature
		MethodSignature ms = (MethodSignature)joinpoint.getSignature();
		System.out.println("Method: "+ ms);
		
		//display method arguments
		Object[] args = joinpoint.getArgs();
		for(Object tempArgs :args) {
			System.out.println("Arguments: "+tempArgs);//Address
			
			if (tempArgs instanceof Account ) {
				//downcast and print account specific stuff
				Account theAccount = (Account)tempArgs;
				System.out.println("account name: "+theAccount.getName());
				System.out.println("account Level: "+theAccount.getLevel());
			}
		}
	}

}
