package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {

	@GetMapping("/home")
	public String getHome() {
		return "home";
	}
	
	@GetMapping("/welcome")
	public String getWelcome() {
		return "welcome";
	}
	
	@GetMapping("/student")
	public String getStudent() {
		return "student";
	}
	
	@GetMapping("/admin")
	public String getAdmin() {
		return "admin";
	}
	
	@GetMapping("/hr")
	public String getHr() {
		return "hr";
	}
	@GetMapping("/common")
	public String getCommonPage() {
		return "commonpage";
	}
	
	@GetMapping("/accessDenied")
	public String getAccessDeniedPage() {
		return "accessDeniedPage";
	}
	
}
