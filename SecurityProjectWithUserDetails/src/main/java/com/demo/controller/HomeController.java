package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/home")
	public String getHomePage() {
		return "home";
	}
	
	@GetMapping("/welcome")
	public String getWelcomePage() {
		return "welcome";
	}
	
	@GetMapping("/admin")
	public String getAdminPage() {
		return "admin";
	}
	
	@GetMapping("/emp")
	public String getEmployeePage() {
		return "emp";
}
	@GetMapping("/manager")
	public String getManagerPage() {
		return "manager";
	}
	
	@GetMapping("/hr")
	public String getHrPage() {
		return "hr";
	}
	
	@GetMapping("/common")
	public String getCommonPage() {
		return "common";
	}
}