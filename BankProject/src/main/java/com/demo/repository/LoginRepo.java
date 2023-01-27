package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demo.entity.LoginEntity;

public interface LoginRepo extends JpaRepository<LoginEntity, Integer> {

	@Query(value = " SELECT* FROM login_entity WHERE email=?1", nativeQuery = true)
	public LoginEntity findByEmail(String email);

}
