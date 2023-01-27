package com.jwtexample.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jwtexample.model.JwtRequest;
@Repository
public interface JwtRequestRepository extends CrudRepository<JwtRequest, Long>{
	
	@Query(value  ="select * from login_entity where username=?1",nativeQuery = true)
	 public JwtRequest findByUsername(String username);

}
