package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.entity.Customer;
import com.demo.entity.LoginEntity;
import com.demo.repository.CustomerRepository;
import com.demo.repository.LoginRepo;
import com.demo.service.CustomerServiceImpl;
import com.demo.service.LoginServiceImpl;

@Controller
public class CustomerController {
	@Autowired
	CustomerRepository repository;

	@Autowired
	CustomerServiceImpl customerServiceImpl;

	@Autowired
	LoginServiceImpl impl;
	@Autowired
	LoginRepo loginRepo;

	@PostMapping("/savecustomer")
	public String saveCustomers(@ModelAttribute Customer customer, Model model) {
		if ((customer.getName() != null )&& (customer.getEmail() != null) && (customer.getPassword() != null)
				&& (customer.getContact() != null) && (customer.getAddress() != null)) {
			Long accno = customerServiceImpl.saveCustomer(customer);
			LoginEntity loginEntity = new LoginEntity();
			loginEntity.setEmail(customer.getEmail());
			loginEntity.setPassword(customer.getPassword());
			loginEntity.setRole(customer.getRole());
			impl.saveLoginData(loginEntity);
			model.addAttribute("message","Your account has been created and your account number is :" + accno
					+ " and Your account balance is " + customer.getBalance());
			return "customerpages/CustomerRegistrationPage";
		} else {
			model.addAttribute("message","Please Fill All Details" );
			return "customerpages/CustomerRegistrationPage";

		}

	}

	@GetMapping("emp/paginationpage")
	public String getPaging(Model model) {
		return getPagination(1, model);
	}

	@PostMapping("/deletecustomer")
	public String deleteCustomer(@ModelAttribute Customer customer, Model model) {
		Customer dbcustomer = customerServiceImpl.findCustomer(customer.getEmail());
		if (dbcustomer != null) {
			repository.deleteById(dbcustomer.getCid());
			LoginEntity loginEntity = impl.findLogin(customer.getEmail());
			loginRepo.deleteById(loginEntity.getId());
			model.addAttribute("message","Customer data deleted" );
			return "customerpages/CustomerRegistrationPage";
		} else {
			model.addAttribute("message", " Enterd Details : " + customer.getEmail() + " are invalid");
			return "employeepages/DeleteCustomer";
		}

	}

	@GetMapping("/getbalance")
	public String getCustomerBalance(@ModelAttribute Customer customer, Model model) {
		Double amt = repository.getBalanceFromDB(customer.getAccountnumber());
		if (amt != null) {
			model.addAttribute("message","You account balance is :" + amt );
			return "customerpages/ShowBalance";
		} else {
			model.addAttribute("message", "Your Entered Account Number is invalid :" + customer.getAccountnumber());
			return "customerpages/ShowBalance";
		}

	}

	@RequestMapping(value = "/depositamt", method = RequestMethod.POST)
	public String depositAmount(@ModelAttribute Customer customer, Model model) {
		Customer dbcustomer = repository.findByAccountnumber(customer.getAccountnumber());
		if (dbcustomer != null) {
			Double customeramt = dbcustomer.getBalance();
			Double userenteredamt = customer.getBalance();
			Double total = customeramt + userenteredamt;
			dbcustomer.setBalance(total);
			customerServiceImpl.saveUpdateCustomer(dbcustomer);
			model.addAttribute("message", "money deposited amount is :" + customer.getBalance() + " and total balance is :"
					+ dbcustomer.getBalance() );
			return "customerpages/Deposit";
		} else {
			model.addAttribute("message", "Your Entered Account Number is invalid :" + customer.getAccountnumber());
			return "customerpages/Deposit";
		}

	}

	@RequestMapping(value = "/withdrawamt", method = RequestMethod.POST)
	public String withDrawAmount(@ModelAttribute Customer customer, Model model) {
		Customer dbcustomer = repository.findByAccountnumber(customer.getAccountnumber());
		if (dbcustomer != null) {
			Double customeramt = dbcustomer.getBalance();
			Double userenteredamt = customer.getBalance();
			Double total = customeramt - userenteredamt;
			dbcustomer.setBalance(total);
			customerServiceImpl.saveUpdateCustomer(dbcustomer);
			model.addAttribute("message","money withdraw from amount is :" + customer.getBalance() + " and total balance is :"
					+ dbcustomer.getBalance());
			return "customerpages/Withdraw";
		} else {
			model.addAttribute("message","Your Entered Account Number is invalid :" + customer.getAccountnumber());
			return "customerpages/Withdraw";
		}

	}

	@GetMapping("/pagination/{pageno}")
	public String getPagination(@PathVariable(value = "pageno") Integer pageno, Model model) {
		Integer pagesize = 3;
		Page<Customer> page = customerServiceImpl.getAllCustomerForPaging(pageno, pagesize);
		List<Customer> customers = page.getContent();

		model.addAttribute("currentPage", pageno);
		model.addAttribute("totalpage", page.getTotalPages());
		model.addAttribute("totalitems", page.getTotalElements());
		model.addAttribute("paging", customers);
		return "employeepages/Pagination";
	}

}
