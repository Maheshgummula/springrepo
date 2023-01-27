package com.jwtexample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwtexample.repository.JwtRequestRepository;
@Service
public class JwtRequestServiceImpl {
	@Autowired
	JwtRequestRepository requestRepository;
	
}
