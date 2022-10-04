package com.learning.springdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.learning.springdemo.entity.Account;

@Component
public class AccountDAO {

	private String accountName;
	private String serviceCode;

	// add a new method : findAccounts

	public List<Account> findAccounts() {

		List<Account> myAccounts = new ArrayList<>();
		//Create sample accounts and add them to accounts list
		
		myAccounts.add(new Account("John", "Silver"));
		myAccounts.add(new Account("Madhu", "Platinum"));
		myAccounts.add(new Account("Grace", "Gold"));
		
		return myAccounts;
	}

	public String getAccountName() {
		System.out.println(getClass() + "getAccountName");
		return accountName;
	}

	public void setAccountName(String accountName) {
		System.out.println(getClass() + "setAccountName");
		this.accountName = accountName;
	}

	public String getServiceCode() {
		System.out.println(getClass() + "getServiceCode");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + "setServiceCode");
		this.serviceCode = serviceCode;
	}

	public void addAccount() {
		System.out.println(getClass() + " invoked add Account method in Account Dao");
	}

	public void addAccount(Account account) {
		System.out.println(getClass() + "invoked add Address method in Account Dao");
	}

}
