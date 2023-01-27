//package com.consumingapi.secutity;
//
//import org.apache.tomcat.util.codec.binary.Base64;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
//@EnableWebSecurity
//@Configuration
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//http.authorizeHttpRequests().antMatchers("/**").permitAll().anyRequest().authenticated().and().csrf().disable();
//	}
//	
//	
//	@Bean
//	public Pbkdf2PasswordEncoder getEncoder() {
//		return new Pbkdf2PasswordEncoder();
//	}
//
//}
