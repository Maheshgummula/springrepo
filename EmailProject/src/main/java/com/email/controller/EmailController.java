package com.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.email.entity.EmailDetails;
import com.email.service.EmailService;

@RestController
public class EmailController {
	@Autowired
	EmailService service;
	
@PostMapping("/sendMail")
	public String sendMail(@RequestBody EmailDetails details) {
		String status=service.sendSimpleMail(details);
		return status;
		
	}
	
}
