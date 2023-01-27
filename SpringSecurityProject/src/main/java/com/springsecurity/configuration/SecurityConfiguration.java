package com.springsecurity.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.jaas.memory.InMemoryConfiguration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	MyCustomerAuthProvider authProvider;
	
	@Bean
	public UserDetailsService userDetailsService() {
		UserDetailsManager manager =new InMemoryUserDetailsManager();
		manager.createUser(User.withUsername("Mahi").password("123").authorities("Student").build());
		return manager;
	}
	
	@Bean
	public PasswordEncoder getpasswordEncoder() {
		return  NoOpPasswordEncoder.getInstance();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
auth.authenticationProvider(authProvider);
	}
}
