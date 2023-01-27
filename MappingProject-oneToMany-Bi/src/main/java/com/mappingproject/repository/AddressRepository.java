package com.mappingproject.repository;

import org.springframework.data.repository.CrudRepository;

import com.mappingproject.model.Address;

public interface AddressRepository extends CrudRepository<Address, Long> {

}
