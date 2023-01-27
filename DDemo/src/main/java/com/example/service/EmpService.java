package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.Employee;
@Service
public interface EmpService {
	public List<Employee> list();
	

}
