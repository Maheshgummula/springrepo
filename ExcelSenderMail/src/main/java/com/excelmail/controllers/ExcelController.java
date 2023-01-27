package com.excelmail.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.excelmail.entity.MailEntity;
import com.excelmail.service.ExcelService;

@RestController
public class ExcelController {
	
	@Autowired
	ExcelService service;
	
	@GetMapping()
	public ResponseEntity<?> get(@RequestBody MailEntity entity){
		service.sendMailWithAttachment(entity.getRecipient(), entity.getSubject(), entity.getBody() );
		
		return null;
		
	}

}
