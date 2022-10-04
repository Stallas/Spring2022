package com.learning.springdemo.Aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.learning.springdemo.entity.Account;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {

	/*
	 * AfterReturning --(Successful execution)
	 * 
	 * JoinPoint --> gives metadata about the method call.
	 * Result --> captures the method output . 
	 * Method parameter result should match with returning field i.e. result
	 */
	@AfterReturning(pointcut = "execution(* com.learning.springdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
	public void afterReturningFindAccountsMethod(JoinPoint joinpoint, List<Account> result) {

		// print out which method we are advising on
		String method = joinpoint.getSignature().toShortString();
		System.out.println("Executing @AfterReturning on method: " + method);

		// print out the results of the method call
		System.out.println("Result is:  " + result);
		
		// post-process the data... modify the result
		
		// convert the account names to uppercase()
		convertAccountNamesToUpperCase(result);
		
		System.out.println("Result is:  " + result);
	}

	private void convertAccountNamesToUpperCase(List<Account> result) {
	
		//loop through accounts 
		for(Account tempAcc : result) {
			
			//get the uppercase versions of name
			String theUpperName = tempAcc.getName().toUpperCase();
			
			//update the name on the account
			tempAcc.setName(theUpperName);
		}
		
		
		
		
	}


}
