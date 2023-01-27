package com.votingapp.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.votingapp.model.LoginEntity;
@Repository
public interface LoginRepository extends CrudRepository<LoginEntity, Integer> {
LoginEntity findByEmail(String email);
}
