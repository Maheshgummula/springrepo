package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.demo.entities.User;
import com.demo.service.IUserService;

@Controller
public class UserController {
	@Autowired
	IUserService iUserService;

	@GetMapping("/register")
	public String register() {
		return "register";
	}
	@PostMapping("/saveuser")
	public String saveUser(@ModelAttribute User user,Model model) {
		Long id=iUserService.saveUser(user);
		String msg=" User"+id+"saved succesfully";
		model.addAttribute("message",msg);		
		return "register";
	}
	

}
