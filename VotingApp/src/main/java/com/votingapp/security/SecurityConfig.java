package com.votingapp.security;

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

import com.votingapp.enums.Roles;
import com.votingapp.model.LoginEntity;
import com.votingapp.service.LoginServiceImpl;
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	UserDetailsService service;
	@Autowired
	SuccessHandler  handler;
	
@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
auth.userDetailsService(service);
}  
@Override
	protected void configure(HttpSecurity http) throws Exception {

	http.authorizeHttpRequests().antMatchers("/register").permitAll().antMatchers("admin*/**").hasAuthority(Roles.ADMIN.toString())
	.antMatchers("voter*/**").hasAuthority(Roles.VOTER.toString())
	.antMatchers("/**").permitAll()
	.anyRequest().authenticated()
	.and().formLogin().loginPage("/login").usernameParameter("email").passwordParameter("password").successHandler(handler).and().csrf().disable().httpBasic().and().logout()
	.logoutRequestMatcher(new AntPathRequestMatcher("/logout"));	
	}
@Bean
LoginEntity getLogin() {
	return new LoginEntity();
}

@Bean
public PasswordEncoder get() {
	return NoOpPasswordEncoder.getInstance();
}

}
