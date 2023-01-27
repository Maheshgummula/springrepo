package com.buykart.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.buykart.dto.CustomerDto;
import com.buykart.repositories.CustomerRepository;
import com.buykart.services.CustomerServiceImpl;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerServiceImpl customerServiceImpl;
	
@PostMapping("/addCustomer")
public ResponseEntity<String> addCustomer(@RequestBody CustomerDto customerDto){
	customerServiceImpl.saveCustomer(customerDto);
	return new ResponseEntity<String>("Customer Added", HttpStatus.CREATED);
}
}
