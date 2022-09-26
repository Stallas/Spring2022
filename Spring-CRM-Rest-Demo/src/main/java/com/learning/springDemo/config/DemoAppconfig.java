package com.learning.springDemo.config;

import java.beans.PropertyVetoException;

import javax.activation.DataSource;

import org.hibernate.cfg.Environment;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = "com.learning.springDemo")
@PropertySource({"classpath:persistence-myql.properties"})
public class DemoAppconfig implements WebMvcConfigurer{

	@Autowired
	private Environment env;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Bean
	public DataSource myDataSource() {
		
		// create a connection pool
		ComboPooledDataSource myDataSource = new ComboPooledDataSource();
		
		// Set the jdbc driver
		try {
			myDataSource.setDriverClass("com.mysql.jdbc.Driver");
		}
		catch (PropertyVetoException exc) {
			throw new RuntimeException(exc);
		}
		
		//for Sanity's sake, let's log url and user.... just to make sure we 
//		logger.info("jdbc.url="+env.getProperty("jdbc.url"));
//		logger.info("jdbc.user="+env.getProperty("jdbc.user"));
	}
}
