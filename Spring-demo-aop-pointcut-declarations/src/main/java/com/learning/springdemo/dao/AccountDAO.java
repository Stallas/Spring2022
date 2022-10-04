package com.learning.springdemo.dao;

import org.springframework.stereotype.Component;

import com.learning.springdemo.entity.Account;

@Component
public class AccountDAO {

	public void addAccount() {
		System.out.println(getClass() + " invoked add Account method in Account Dao");
	}
	
	public void addAddress() {
		System.out.println(getClass() + "invoked add Address method in Account Dao");
	}
	
	public void addAccount(Account account) {
		System.out.println(getClass() + "invoked add Address method in Account Dao");
	}
}
