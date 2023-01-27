package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Employee;
import com.example.service.EmpService;
import com.example.service.EmpServiceImpl;

@RestController
@RequestMapping("/getlist")
public class Controllerr {

	@Autowired
	private EmpService service;

	@GetMapping()
	public List<Employee> list() {
		return service.list();
	}

	@GetMapping("/getstring")
	public String getString() {
		return "Hii Mahesh";
	}

}
