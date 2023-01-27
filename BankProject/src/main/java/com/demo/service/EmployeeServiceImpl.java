package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.Employee;
import com.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public String saveEmployee(Employee employee) {
		employee.setRole("Employee");
		employeeRepository.save(employee);
		return "Employee Inserted Succesfully";
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public void deleteEmployee(Integer id) {
		employeeRepository.deleteById(id);

	}

	@Override
	public Employee findCustomer(String email) {
		// TODO Auto-generated method stub
		return employeeRepository.findByEmail(email);
	}

}
