package com.demo.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.demo.entities.User;
import com.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserDetailsService, IUserService {

	@Autowired
	private UserRepository repository;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> op = repository.findByName(username);
		org.springframework.security.core.userdetails.User userinternal = null;
		if (op.isEmpty()) {
			throw new RuntimeException("Something went wrong");
		} else {
			User user2 = op.get();
			List<String> roles = user2.getRoles();
			Set<GrantedAuthority> authorities = new HashSet<>();
			for (String role : roles) {
				authorities.add(new SimpleGrantedAuthority(role));
			}
			userinternal = new org.springframework.security.core.userdetails.User(username, user2.getPassword(),
					authorities);
		}
		return userinternal;
	}

	@Override
	public Long saveUser(User user) {
		String password = user.getPassword();
		String encodePassword = encoder.encode(password);
		user.setPassword(encodePassword);
		user = repository.save(user);
		return user.getId();
	}

}
