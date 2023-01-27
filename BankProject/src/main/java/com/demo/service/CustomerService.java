package com.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.demo.entity.Customer;

public interface CustomerService {
	public Long saveCustomer(Customer customer);

	public void saveUpdateCustomer(Customer customer);

	public List<Customer> getAllCustomers();

	public Customer getCustomer(Integer id);

	public Customer findCustomer(String email);

	public Customer updateCustomer(Integer id);

	public Page<Customer> getAllCustomerForPaging(Integer pageno, Integer pagesize);
}
