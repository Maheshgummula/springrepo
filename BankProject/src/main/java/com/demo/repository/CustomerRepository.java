package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	@Query(value = "SELECT balance FROM customer WHERE accountnumber=?1", nativeQuery = true)
	public Double getBalanceFromDB(Long accountnumber);

	@Query(value = "SELECT * FROM customer WHERE accountnumber=?1", nativeQuery = true)
	public Customer findByAccountnumber(Long accountnumber);

	@Query(value = "SELECT * FROM customer ORDER BY cid DESC LIMIT 1", nativeQuery = true)
	public Customer getLastElement();

	@Query(value = " SELECT* FROM customer WHERE email=?1", nativeQuery = true)
	public Customer findByEmail(String email);

}
