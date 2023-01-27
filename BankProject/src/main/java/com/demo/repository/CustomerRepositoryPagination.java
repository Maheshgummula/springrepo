package com.demo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.demo.entity.Customer;

@Repository
public interface CustomerRepositoryPagination extends PagingAndSortingRepository<Customer, Integer> {

}
