package com.demo.schedular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.demo.entity.Customer;
import com.demo.repository.CustomerRepository;
import com.demo.service.EmailServiceImpl;

@Component
public class EmailSchedular {

	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	EmailServiceImpl emailServiceImpl;
	
	
	
	@Scheduled(cron = "0 59 * * * *")
	public void cronSchedule() {
		Customer customer=customerRepository.getLastElement();
		String email=customer.getEmail();
		emailServiceImpl.sendSimpleMail(email, "Welcome", "Welcome to the Bank");
		System.out.println("sent succesfully");
		
		
	}
}
