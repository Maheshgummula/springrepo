package com.demo.security;

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
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@SuppressWarnings("deprecation")
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	UserDetailsService detailsService;
	@Autowired
	SuccessHandlerForAll successHandlerForAll;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(detailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests()
				.antMatchers("/register", "/defaultwelcome", "/verifying", "/savecustomer", "/getLogout").permitAll()
				.antMatchers("/admin*/**").hasAuthority("Admin").antMatchers("/emp*/**").hasAuthority("Employee")
				.antMatchers("/customer*/**").hasAuthority("Customer").anyRequest().authenticated()

				.and().formLogin().successHandler(successHandlerForAll).and().logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/defaultwelcome")
				// Exception Details
				.and().exceptionHandling().accessDeniedPage("/accessDenied");

	}

	@Bean
	public PasswordEncoder getEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
