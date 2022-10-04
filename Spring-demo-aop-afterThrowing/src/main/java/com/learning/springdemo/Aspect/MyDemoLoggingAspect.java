package com.learning.springdemo.Aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.learning.springdemo.entity.Account;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {

	/*
	 * AfterThrowing--(Successful execution)
	 * 
	 * JoinPoint --> gives metadata about the method call.
	 * theExc --> captures the Exception . 
	 * Method parameter result should match with throwing field i.e. theExc
	 */
	@AfterThrowing(pointcut = "execution(* com.learning.springdemo.dao.AccountDAO.findAccounts(..))", throwing = "theExc")
	public void afterThrowingFindAccountsMethod(JoinPoint joinpoint, Throwable theExc) {

		// print out which method we are advising on
		String method = joinpoint.getSignature().toShortString();
		System.out.println("Executing @AfterThrowing on method: " + method);

		// Log the exception
		System.out.println("Log Exception:  " + theExc);
		
	}

		
		
		
		


}
