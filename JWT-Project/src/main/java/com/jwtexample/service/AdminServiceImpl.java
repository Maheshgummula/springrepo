package com.jwtexample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwtexample.enums.Role;
import com.jwtexample.model.Customer;
import com.jwtexample.model.JwtRequest;
import com.jwtexample.repository.AdminRepository;

@Service
public class AdminServiceImpl {

	@Autowired
	AdminRepository adminRepository;
	
}
