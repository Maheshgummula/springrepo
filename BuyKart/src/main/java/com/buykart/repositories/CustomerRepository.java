package com.buykart.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.buykart.entities.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
