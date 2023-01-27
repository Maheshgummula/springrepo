package com.jwtrsa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwtrsa.service.RSAService;

@RestController
public class RsaController {

	@Autowired
	RSAService service;
	
	@GetMapping("/generate")
	public ResponseEntity<String> getting(){
		
		return new ResponseEntity<String>(service.getValue(), HttpStatus.OK);
	}
}
