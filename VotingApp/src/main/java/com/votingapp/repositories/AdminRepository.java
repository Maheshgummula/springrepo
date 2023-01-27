package com.votingapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.votingapp.model.Admin;

public interface AdminRepository extends CrudRepository<Admin, String> {

}
