package com.learning.springdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.learning.springdemo.dao.AccountDAO;
import com.learning.springdemo.entity.Account;

public class AfterFinallyDemoApp {

	public static void main(String[] args) {
		
		//read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoAppConfig.class);
		
		//get the bean from Spring container
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		//call the method to find the accounts
		List<Account> theAccounts = null;
		try {
			//boolean flag = false;
			boolean flag = true;
			theAccounts = accountDAO.findAccounts(flag);
		} catch (Exception e) {
			System.out.println("\n\n Exception Caught in Main program: "+ e);
		}
		
		System.out.println("Display the Accounts: "+theAccounts);
		
		//close the context
		context.close();
	}
}
