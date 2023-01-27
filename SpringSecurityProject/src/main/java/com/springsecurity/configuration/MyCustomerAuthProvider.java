package com.springsecurity.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
@Component
public class MyCustomerAuthProvider implements AuthenticationProvider {

	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// TODO Auto-generated method stub
		
		var user=userDetailsService.loadUserByUsername(authentication.getName());
		 if (user!=null && passwordEncoder.matches(authentication.getCredentials().toString(), user.getPassword())) {
			 System.out.println(authentication.getCredentials());
		return	new UsernamePasswordAuthenticationToken(authentication.getName(), authentication.getCredentials(),authentication.getAuthorities());
		}
		return null;
//				new UsernamePasswordAuthenticationToken(authentication.getName(), authentication.getCredentials(),authentication.getAuthorities());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return  UsernamePasswordAuthenticationToken.class.equals(authentication);
	}

}
