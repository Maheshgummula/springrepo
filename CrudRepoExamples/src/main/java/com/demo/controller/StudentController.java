package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.demo.entity.Student;
import com.demo.repository.StudentRepository;
import com.demo.service.StudentServiceImpl;

@Controller
public class StudentController {
	

	@Autowired
	 StudentServiceImpl serviceImpl;
	@Autowired
	StudentRepository repository;
	
	
	@GetMapping("/register")
	public String getRegister() {
		return "register";
	}
	
	
	
	@PostMapping("/save")
	public String saveStud(Student student) {
		serviceImpl.saveStudent(student);
		return "register";
	}
	@PostMapping("/delete")
	public String deleteStud(Student student) {
		serviceImpl.deleteStudent(student.getContact());
		return "register";
	}
	@PostMapping("/update")
	public String updateStud(Student student) {
	Student sdb=repository.findByContact(student.getContact());
	System.out.println(sdb);
	if (student.getSname()!=null) {
		sdb.setSname(student.getSname());
	}
//	else {
//		sdb.setSname(sdb.getSname());
//		
//	}
	
	if (student.getAddress()!=null) {
		sdb.setAddress(student.getAddress());
	}
//	else {
//		sdb.setAddress(sdb.getAddress());
//	}
	
	if (student.getFees()!=null) {
		sdb.setFees(student.getFees());
	}
//	else {
//		sdb.setFees(sdb.getFees());
//	}
	
		serviceImpl.updateStudent(sdb);
		return "register";
	}
	
}
