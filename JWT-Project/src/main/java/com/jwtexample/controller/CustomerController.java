package com.jwtexample.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwtexample.model.Customer;
import com.jwtexample.service.CustomerServiceImpl;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerServiceImpl serviceImpl;
	
	@GetMapping("/welcome")
	public String getStringMsg() {
		String msg = "welcome customer page";
		return msg;
	}
	
	@PostMapping("/saveCustomer")
	public ResponseEntity<String> saveCustomer(@RequestBody @Valid Customer customer){
		return new ResponseEntity<String>(serviceImpl.saveCustomer(customer),HttpStatus.CREATED);
	}
	
}
