package com.buykart.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buykart.dto.CustomerDto;
import com.buykart.entities.Customer;
import com.buykart.entities.LoginEntityForAll;
import com.buykart.enums.Role;
import com.buykart.repositories.CustomerRepository;
import com.buykart.repositories.LoginEntityRepository;
@Service
public class CustomerServiceImpl implements CustomerService {
@Autowired
CustomerRepository customerRepository;
@Autowired
LoginEntityRepository entityRepository;
	@Override
	public void saveCustomer(CustomerDto customerdto) {
		Customer customer=new Customer(customerdto);
		customer.setRole(Role.CUSTOMER);
		 customerRepository.save(customer);
		 LoginEntityForAll entityForAll = new LoginEntityForAll();
		 entityForAll.setEmailId(customerdto.getEmailId());
		 entityForAll.setPassword(customerdto.getPassword());
		 entityForAll.setRole(customer.getRole());
		 entityRepository.save(entityForAll);
	}

}
