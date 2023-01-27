package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.entity.Employee;
import com.example.repo.EmpRepo;

@Component
public class EmpServiceImpl implements EmpService {
	@Autowired
	private EmpRepo repo;

	@Override
	public List<Employee> list() {

		return repo.findAll();
	}

}
