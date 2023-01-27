//package com.example.demo.security;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//	@Autowired
//	private DataSource dataSource;
//	
////	@Autowired
////	private BCryptPasswordEncoder encoder;
//	
////	@Override
////	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////		auth.inMemoryAuthentication().withUser("max").password("{noop}min").authorities("ADMIN");
////		auth.inMemoryAuthentication().withUser("tom").password("{noop}jerry").authorities("STUDENT");
////		auth.inMemoryAuthentication().withUser("up").password("{noop}down").authorities("HR");
////	}
//	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		
//		auth.jdbcAuthentication().dataSource(dataSource)
//		.usersByUsernameQuery("select user_name,user_pwd,user_enabled from user where user_name=?")
//		.authoritiesByUsernameQuery("select user_name,user_role from user where user_name=?");
////		.passwordEncoder(encoder);
////		.passwordEncoder(encoder);
//	}
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//
//		http.authorizeRequests().antMatchers("/home").permitAll().antMatchers("/welcome").authenticated()
//				.antMatchers("/student").hasAuthority("STUDENT").antMatchers("/admin").hasAuthority("ADMIN")
//				.antMatchers("/hr").hasAuthority("HR").antMatchers("/common").hasAnyAuthority("STUDENT", "HR")
//				.anyRequest().authenticated().and().formLogin().defaultSuccessUrl("/welcome", true)
//				.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//				// Exception Details
//				.and().exceptionHandling().accessDeniedPage("/accessDenied");
//	}
//
//}
