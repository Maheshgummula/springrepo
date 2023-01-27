
package com.jwtexample.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jwtexample.enums.Role;
import com.jwtexample.model.JwtRequest;
import com.jwtexample.repository.JwtRequestRepository;
@Service
public class CustomerUserDetailService implements UserDetailsService{

@Autowired 
private JwtRequestRepository repository;

@Override 
public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException{
	JwtRequest jwtRequest=repository.findByUsername(username);
	System.out.println(jwtRequest.getUsername()+" "+jwtRequest.getPassword());
if (jwtRequest==null) {
	throw new RuntimeException("something went wrong");
}else {
	Role role=jwtRequest.getRole();
	Set<GrantedAuthority>authorities=new HashSet<GrantedAuthority>();
	authorities.add(new SimpleGrantedAuthority(role.name()));
	return new User(username, jwtRequest.getPassword(), authorities);
	
	
}
}
}
