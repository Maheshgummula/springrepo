package com.buykart.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.buykart.entities.AdminEntity;
@Repository
public interface AdminRepository extends CrudRepository<AdminEntity, Integer>{

}
