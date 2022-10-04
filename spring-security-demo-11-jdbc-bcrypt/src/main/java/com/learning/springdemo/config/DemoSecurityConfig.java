package com.learning.springdemo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig {

	/*
	 * Steps to create basic security (Spring provides default login page with built in error message)
	 * 1. Extend AbstractSecurityWebAppInitializer 
	 * 2.Add users to In memory authentication and annotations 3. Run the application
	 * Note: for Password {noop} --> Password storage format followed by actual
	 * password
	 * 
	 * authorizeRequests --> Restricts access based on HttpServletRequest
	 * Any request to the app must be authenticated(i.e logged in)
	 * form login --> show our custom form at the request mapping "/showMyLoginPage"
	 * authenticateTheUser --> Login form should POST(Submit) data to this URL for processing (check user Id and Password)
	 * permitAll --> Allow everyone to see login page. No need to be logged in.
	 * 
	 * Login Processing URL(/authenticateTheUser) will be handled by Spring Security Filters.
	 * Can give any Url
	 * Logout Processing URL(/Logout) will be handled by Spring Security Filters.
	 * 
	 * Saving user/password/roles in database.
	 * Change password in db and test for which no need to restart the db.
	 */
	
	
//	Hardcoded stuff
//	@Bean
//	public InMemoryUserDetailsManager userDetailsService() {
//
//		UserDetails sri = User.builder().username("Sri").password("{noop}test123").roles("EMPLOYEE").build();
//		UserDetails john = User.builder().username("John").password("{noop}test123").roles("EMPLOYEE", "MANAGER").build();
//		UserDetails luci = User.builder().username("Luci").password("{noop}test123").roles("EMPLOYEE","ADMIN").build();
//
//		return new InMemoryUserDetailsManager(sri, john, luci);
//	}

//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//
//		return http
//				.authorizeRequests(configurer -> configurer.anyRequest().authenticated())
//				.formLogin(configurer -> configurer.loginPage("/showMyLoginPage")
//						.loginProcessingUrl("/authenticateTheUser").permitAll())
//				.logout(configurer -> configurer.permitAll())
//				.build();
//	}
	
	// add a reference to our security data source
	private DataSource securityDataSource;
	
	@Autowired
	public DemoSecurityConfig(DataSource securityDataSource) {
		this.securityDataSource = securityDataSource;
	}

	@Bean
	public UserDetailsManager userDetailsManager() {
		return new JdbcUserDetailsManager(securityDataSource);
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		return http
				.authorizeRequests(configurer -> configurer
						.antMatchers("/").hasRole("EMPLOYEE")
						.antMatchers("/leaders/**").hasRole( "MANAGER")
						.antMatchers("/systems/**").hasRole( "ADMIN"))
				.formLogin(configurer -> configurer
						.loginPage("/showMyLoginPage")
						.loginProcessingUrl("/authenticateTheUser")
						.permitAll())
				.logout(configurer -> configurer
						.permitAll())
				.exceptionHandling(configurer -> configurer
						.accessDeniedPage("/access-denied"))
				.build();
	}
}
