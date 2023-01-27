package com.jwtexample.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jwtexample.model.Admin;
@Repository
public interface AdminRepository extends CrudRepository<Admin, Long> {

}
