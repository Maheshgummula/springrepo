package com.demo.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.demo.entity.Customer;
import com.demo.repository.CustomerRepository;
import com.demo.repository.CustomerRepositoryPagination;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerRepositoryPagination pagination;
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public Long saveCustomer(Customer customer) {
		Random random = new Random();
		Long number = (long) random.nextInt(999999);
//		Long number = random.nextLong(999999);
		customer.setAccountnumber(number);
		customer.setBalance(0.0);
		customer.setRole("Customer");
		customerRepository.save(customer);
		return customer.getAccountnumber();
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Customer getCustomer(Integer id) {
		return customerRepository.findById(id).get();
	}

	@Override
	public Customer findCustomer(String email) {
		return customerRepository.findByEmail(email);
	}

	@Override
	public Customer updateCustomer(Integer id) {
		return customerRepository.findById(id).get();
	}

	@Override
	public Page<Customer> getAllCustomerForPaging(Integer pageno, Integer pagesize) {
		Pageable pageable = PageRequest.of(pageno - 1, pagesize);
		return customerRepository.findAll(pageable);
	}

	@Override
	public void saveUpdateCustomer(Customer customer) {
		customerRepository.save(customer);
	}

}
