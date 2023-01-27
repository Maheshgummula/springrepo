package com.jwtexample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwtexample.enums.Role;
import com.jwtexample.model.Customer;
import com.jwtexample.model.JwtRequest;
import com.jwtexample.repository.CustomerRepository;
import com.jwtexample.repository.JwtRequestRepository;

@Service
public class CustomerServiceImpl {
	@Autowired
	CustomerRepository repository;
	
	@Autowired
	JwtRequestRepository requestRepository;
	
	
	public String saveCustomer(Customer customer) {
		customer.setRole(Role.CUSTOMER);
		Customer customerob=repository.save(customer);
		JwtRequest request=new JwtRequest();
		request.setUsername(customer.getEmail());
		request.setPassword(customer.getPassword());
		request.setRole(customer.getRole());
		requestRepository.save(request);
		if (customerob!=null) {
			return "Customer Data Saved Successfully!";
		}else {
			return "Something Went Wrong!";
		}
	}
	
	
	
	

}
