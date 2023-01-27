package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repo.EmpRepo;

@Service
public class EmpServiceImpl implements EmpService {
	@Autowired
	private EmpRepo repo;

	@Override
	public List<Employee> list() {

		return repo.findAll();
	}

}
