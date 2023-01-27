package com.votingapp.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.votingapp.model.LoginEntity;
import com.votingapp.model.Voter;
import com.votingapp.repositories.LoginRepository;
@Service
public class LoginServiceImpl implements UserDetailsService   {
@Autowired
LoginRepository repository;
	String Username;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		System.out.println(email);
		LoginEntity  voters=repository.findByEmail(email);
		System.out.println(voters+" this  form loadbyusername");
User user=null;
if (voters==null) {
	throw new RuntimeException("Something went wrong!");
}else {
this.Username=voters.getEmail();
	String role=voters.getRole();
	Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
	authorities.add(new SimpleGrantedAuthority(role));
	user=new User(voters.getEmail(), voters.getPassword(), authorities);
}
		return user;
	}

public String getUsername(){ return this.Username;
}

public void save(LoginEntity entity) {
	repository.save(entity);
}
}
