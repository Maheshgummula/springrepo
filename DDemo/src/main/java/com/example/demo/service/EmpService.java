package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
@Service
public interface EmpService {
	public List<Employee> list();
	

}
