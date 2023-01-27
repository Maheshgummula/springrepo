package com.mappingproject.repository;

import org.springframework.data.repository.CrudRepository;

import com.mappingproject.model.Course;
import com.mappingproject.model.Instructor;

public interface InstructorRepository extends CrudRepository<Instructor, Long>{

}
