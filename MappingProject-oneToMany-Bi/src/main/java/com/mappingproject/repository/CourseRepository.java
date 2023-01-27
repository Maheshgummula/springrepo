package com.mappingproject.repository;

import org.springframework.data.repository.CrudRepository;

import com.mappingproject.model.Course;

public interface CourseRepository extends CrudRepository<Course, Long> {

}
