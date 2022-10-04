package com.learning.springdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig {

	/* Steps to create basic security (Spring provides default login page with built in error message)
	 * 1. Extend AbstractSecurityWebAppInitializer
	 * 2. Add users to In memory authentication and annotations
	 * 3. Run the application
	 * Note: for Password {noop} --> Password storage format followed by actual password
	 * */
	
	@Bean
	public InMemoryUserDetailsManager userDetailsService() {

		UserDetails sri = User.builder().username("Sri").password("{noop}test123").roles("EMPLOYEE").build();
		UserDetails john = User.builder().username("John").password("{noop}test123").roles("MANAGER").build();
		UserDetails luci = User.builder().username("Luci").password("{noop}test123").roles("ADMIN").build();

		return new InMemoryUserDetailsManager(sri, john, luci);
	}
}
