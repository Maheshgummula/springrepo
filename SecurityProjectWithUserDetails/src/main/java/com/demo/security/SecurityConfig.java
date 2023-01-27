package com.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
@Autowired
UserDetailsService dts;
@Autowired
BCryptPasswordEncoder encoder;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(dts).passwordEncoder(encoder);
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		http.authorizeRequests()
		.antMatchers("/home","/register","/saveuser").permitAll()
		.antMatchers("/welcome").authenticated()
		.antMatchers("/admin").hasAuthority("Admin")
		.antMatchers("/manager").hasAuthority("Manager")
		.antMatchers("/emp").hasAuthority("Employee")
		.antMatchers("/hr").hasAuthority("HR")
		.antMatchers("/common").hasAnyAuthority("Employee","Manager","Admin")
		.anyRequest().authenticated()
		
		.and()
		.formLogin()
		.defaultSuccessUrl("/welcome",true)
		
		.and()
		.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
	}
}
