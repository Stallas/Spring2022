package com.learning.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.learning.springdemo.dao.AccountDAO;
import com.learning.springdemo.entity.Account;

public class MainApp {

	public static void main(String[] args) {
		
		//read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoAppConfig.class);
		
		//get the bean from Spring container
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		//call the business method
		Account myAccount = new Account();
		myAccount.setName("John");
		myAccount.setLevel("silver");
		accountDAO.addAccount(myAccount);
		accountDAO.addAccount();
		
		//call the appropriate getter and setter methods
		accountDAO.setAccountName("John");
		accountDAO.setServiceCode("silver");
		
		accountDAO.getAccountName();
		accountDAO.getServiceCode();
		//close the context
		context.close();
	}
}
