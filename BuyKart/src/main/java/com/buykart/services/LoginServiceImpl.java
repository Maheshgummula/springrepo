package com.buykart.services;

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

import com.buykart.entities.LoginEntityForAll;
import com.buykart.enums.Role;
import com.buykart.repositories.LoginEntityRepository;
@Service
public class LoginServiceImpl implements UserDetailsService {
	@Autowired
	LoginEntityRepository entityRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		 LoginEntityForAll logingentity=entityRepository.findByEmail(email);
		 // Creating User reference of UserDetails
		 User user=null;
		 if (logingentity==null) {
			throw new RuntimeException("Something Went Wrong!");
		}else {
			
			//Returning the user 
			Role role=logingentity.getRole();
			Set<GrantedAuthority>authorities=new HashSet<GrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority(role.name()));
			user=new User(email, logingentity.getPassword(), authorities);
			System.out.println("executed");
			return user;
		}
	}

}
