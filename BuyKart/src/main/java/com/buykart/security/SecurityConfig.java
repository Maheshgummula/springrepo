package com.buykart.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.buykart.enums.Role;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsService service;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(service);

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().and().httpBasic().and().authorizeRequests().antMatchers("/admin*/**")
				.hasAuthority(Role.ADMIN.name()).antMatchers("/customer*/**").hasAuthority(Role.CUSTOMER.name())
				.antMatchers("/addCustomer", "/getAllCategories", "/getAllCategoriesByName", "/searchCategoriesByName",
						"/getAllProducts", "/getAllProductsByName", "/searchProductsByName")
				.permitAll().anyRequest().authenticated();

	}

	@Bean
	public PasswordEncoder getEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
