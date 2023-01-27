package com.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController
{
	@GetMapping("/welcome")
	public String getWelcome() {
		return "HI Maheshh";
	}

}
