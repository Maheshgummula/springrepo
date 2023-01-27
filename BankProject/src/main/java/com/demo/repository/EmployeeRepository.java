package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	@Query(value = "SELECT SUM(balance) FROM customer", nativeQuery = true)
	public Double getBalanceAdditionFromDB();

	@Query(value = " SELECT* FROM employee WHERE email=?1", nativeQuery = true)
	public Employee findByEmail(String email);

}
