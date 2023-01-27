package com.demo.service;

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

//import com.demo.entities.User;
import com.demo.entity.LoginEntity;
import com.demo.repository.LoginRepo;

@Service
public class LoginServiceImpl implements UserDetailsService {
	@Autowired
	LoginRepo loginRepo;

	public void saveLoginData(LoginEntity entity) {
		loginRepo.save(entity);

	}

	public LoginEntity findLogin(String email) {
		return loginRepo.findByEmail(email);

	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		LoginEntity loginEntity = loginRepo.findByEmail(email);
		User userinternal = null;
		if (loginEntity == null) {
			throw new RuntimeException("Something went wrong");
		} else {
			String role = loginEntity.getRole();
			Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority(role));
			userinternal = new User(email, loginEntity.getPassword(), authorities);
		}
		return userinternal;
	}
}
