package com.demo.service;

import java.util.List;

import com.demo.entity.Employee;

public interface EmployeeService {
	public String saveEmployee(Employee employee);

	public List<Employee> getAllEmployee();

	public void deleteEmployee(Integer id);

	public Employee findCustomer(String email);

}
