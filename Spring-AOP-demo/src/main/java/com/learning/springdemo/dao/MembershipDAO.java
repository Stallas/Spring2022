package com.learning.springdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public void addAccount() {
		System.out.println(getClass() + "invoked add Account method in Membership Dao");
	}
	
	public boolean addMembership() {
		System.out.println(getClass() + "invoked add membership method in Membership Dao");
		
		return false;
	}
}
