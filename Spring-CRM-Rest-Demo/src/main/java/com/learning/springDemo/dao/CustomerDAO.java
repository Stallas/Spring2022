package com.learning.springDemo.dao;

import java.util.List;

import com.learning.springDemo.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();
	
	public void savecustomer(Customer theCustomer);
	
	public Customer getCustomers(int theId);
	
	public void deleteCustomer(int theId);
}
