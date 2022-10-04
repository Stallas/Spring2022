package com.learning.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.learning.springdemo.dao.AccountDAO;
import com.learning.springdemo.dao.MembershipDAO;
import com.learning.springdemo.entity.Account;

public class MainApp {

	public static void main(String[] args) {
		
		//read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoAppConfig.class);
		
		//get the bean from Spring container
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		//get membership bean from spring container
		MembershipDAO membershipDAO = context.getBean("membershipDAO",MembershipDAO.class);
		
		//call the business method
		accountDAO.addAccount();
		
		//accountDAO.addAddress();
		accountDAO.addAccount(new Account());
		
		//call the membership business method
		membershipDAO.addAccount();
		
		membershipDAO.addMembership();
		
//		//do it again !!
//		System.out.println("Invoking the same method again..... ");
//		accountDAO.addAccount();
		
		//close the context
		context.close();
	}
}
