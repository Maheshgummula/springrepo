
package com.jwtexample.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jwtexample.helper.JwtUtilHelperClass;
import com.jwtexample.model.JwtRequest;
import com.jwtexample.model.JwtResponse;
import com.jwtexample.service.CustomerUserDetailService;

@RestController
public class JwtController {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	JwtUtilHelperClass helperClass;

	@Autowired
	private CustomerUserDetailService service;



	@PostMapping("/token")
	public ResponseEntity<?> getToken(@RequestBody JwtRequest request) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword(),new ArrayList<>()));
		} catch (UsernameNotFoundException e) {
			e.printStackTrace();
			throw new Exception("Bad Credentials");
		} catch (BadCredentialsException e) {
			e.printStackTrace();
			throw new Exception("Bad Credentials");
		}catch (Exception e) {
			e.getMessage();
		}
		UserDetails userdetails = service.loadUserByUsername(request.getUsername());
		String token = helperClass.generateToken(userdetails);
		return ResponseEntity.ok(new JwtResponse(token));
	}
}
