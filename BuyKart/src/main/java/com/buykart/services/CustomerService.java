package com.buykart.services;

import com.buykart.dto.CustomerDto;
import com.buykart.entities.Category;
import com.buykart.entities.Customer;

public interface CustomerService {
	public void saveCustomer(CustomerDto customer);
}
