package com.jwtexample.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jwtexample.model.Customer;
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long>
{

}
