package com.learning.springdemo.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	/*
	 * The below method would be executed when bean is not initialized
	 * i.e.@Component
	 * 
	 * @Before(Pointcut expressions)
	 * 
	 * Parameter pattern wildcards: () --> matches a method with no arguments (*)
	 * --> matches a method with one arguments (..) --> matches a method with 0 or
	 * more arguments
	 */

	/* Match addAccount() method of any return type in any class */
	// @Before("execution(* addAccount())")

	/* @Before Advice is never called because no calls to: updateAccount() */
	// @Before("execution(public void updateAccount())")

	/* Match addAccount() method of any class */
	// @Before("execution(public void addAccount())")

	/* Match a fully qualified method name */
	// @Before("execution(public void
	// com.learning.springdemo.dao.AccountDAO.addAccount())")

	/* Match methods starting with add */
	@Before("execution(public void add*())")
	public void beforeAddAccountAdvice() {
		System.out.println("Executing Before Advice method invoked");
	}

	/*
	 * When multiple methods with same signature add* are defined for before advice
	 * then all these methods will be executed inorder before actual method
	 * addAccount invoked
	 */
	@Before("execution(public void add*())")
	public void beforeAddAccountAdvice1() {
		System.out.println("Executing Before Advice method 1 invoked");
	}

	/* Match methods with return type */
	// @Before("execution(void add*())")

	/* Match methods with any return type */
	@Before("execution(* add*())")
	public void beforeAddAccountAdvice2() {
		System.out.println("Match add methods with any return type");
	}

	/*
	 * e.g. addAccount(Account account,boolean flag)
	 * 
	 * @Before("execution(* add*(com.learning.springdemo.entity.Account))")--> no
	 * matches (Before advice doesn't gets executed)
	 * 
	 * @Before("execution(* add*(com.learning.springdemo.entity.Account, ..))")-->
	 * method gets executed
	 * 
	 * @Before("execution(* add*(..))")--> Match on ANY Parameters
	 * 
	 * @Before("execution(* com.learning.springdemo.dao.*.*(..))") --> Match methods in a package
	 */
	// Must match fully qualified param type else(e.g.Account) then warning no match
	// is thrown
	@Before("execution(* add*(com.learning.springdemo.entity.Account))")
	public void beforeAddAccountAdvice3() {
		System.out.println("Match methods with param names");
	}
}
