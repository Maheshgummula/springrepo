package com.mappingproject.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mappingproject.model.Student;
@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

	Student findByFirstname(String firstname);
	
}
