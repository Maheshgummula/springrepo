package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.demo.entity.Employee;
import com.demo.entity.LoginEntity;
import com.demo.repository.EmployeeRepository;
import com.demo.repository.LoginRepo;
import com.demo.service.CustomerServiceImpl;
import com.demo.service.EmployeeServiceImpl;
import com.demo.service.LoginServiceImpl;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeRepository repository;
	@Autowired
	EmployeeServiceImpl employeeServiceImpl;
	@Autowired
	CustomerServiceImpl serviceImpl;
	@Autowired
	LoginServiceImpl impl;
	@Autowired
	LoginRepo loginRepo;

	@PostMapping("/saveemployee")
	public String saveEmployee(@ModelAttribute Employee employee, Model model) {
		if (((employee.getName()) != null) || ((employee.getEmail()) != null) || ((employee.getPassword()) != null)) {
			String msg = employeeServiceImpl.saveEmployee(employee);
			LoginEntity login = new LoginEntity();
			login.setEmail(employee.getEmail());
			login.setPassword(employee.getPassword());
			login.setRole(employee.getRole());
			impl.saveLoginData(login);
			model.addAttribute("message", msg);
			return "adminpages/EmployeeRegistration";
		} else {
			model.addAttribute("message","Please fill out all details" );
			return "adminpages/EmployeeRegistration";
		}

	}

	@PostMapping("/deleteemp")
	public String deleteEmployeeData(@ModelAttribute Employee employee, Model model) {
		Employee dbemployee = employeeServiceImpl.findCustomer(employee.getEmail());
		if (dbemployee != null) {
			repository.deleteById(dbemployee.getId());
			// LoginEntity Deletion
			LoginEntity loginEntity = impl.findLogin(employee.getEmail());
			loginRepo.deleteById(loginEntity.getId());
			model.addAttribute("message", "Employee data deleted");
			return "adminpages/EmployeeRegistration";
		} else {
			model.addAttribute("message", "please enter valid email, your entered email id is " + employee.getEmail());
			return "employeepages/DeleteCustomer";
		}

	}

	@GetMapping("/gettotal")
	public String getAdditionBalance(@ModelAttribute Employee employee, Model model) {
		Double total = repository.getBalanceAdditionFromDB();
		System.out.println(total);
		model.addAttribute("message", "Total Bank Balance is :" + total);
		return "employeepages/TotalBalance";
	}

	@GetMapping("/getemployeecustomerdetails")
	public String getEmployeeCustomerDetails(Model model) {

		model.addAttribute("customerdetails", serviceImpl.getAllCustomers());
		model.addAttribute("employeedetails", employeeServiceImpl.getAllEmployee());
		return "adminpages/EmployeeCustomerPage";
	}

}
