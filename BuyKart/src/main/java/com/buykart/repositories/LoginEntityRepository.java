package com.buykart.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.buykart.entities.LoginEntityForAll;
@Repository
public interface LoginEntityRepository extends CrudRepository<LoginEntityForAll, Integer> {
	@Query(value = "select * from login_entity_for_all where email_id=?1 ",nativeQuery = true)
	public LoginEntityForAll findByEmail(String email);
}
