package com.learning.springDemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Repository;

import com.learning.demo.Instructor;
import com.learning.demo.InstructorDetail;
import com.learning.springDemo.entity.Customer;
import com.mysql.cj.xdevapi.SessionFactory;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// Need to inject the session factory
	private SessionFactory sessionFactory;

	static Session sessionObj;
	static SessionFactory sessionFactoryObj;

	private static SessionFactory buildSessionFactory() {
		// Creating Configuration Instance & Passing Hibernate Configuration File
		Configuration configObj = new Configuration();
		configObj.configure("hibernate.cfg.xml");

		// Since Hibernate Version 4.x, ServiceRegistry Is Being Used
		ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder()
				.applySettings(configObj.getProperties()).build();

		// Creating Hibernate SessionFactory Instance
		sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
		return sessionFactoryObj;
	}

	@Override
	public List<Customer> getCustomers() {

		sessionObj = buildSessionFactory().openSession();
		sessionObj.beginTransaction();
				return null;
	}

	@Override
	public void savecustomer(Customer theCustomer) {
		// TODO Auto-generated method stub

	}

	@Override
	public Customer getCustomers(int theId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCustomer(int theId) {
		// TODO Auto-generated method stub

	}

}
