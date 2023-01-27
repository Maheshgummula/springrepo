package com.mappingproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mappingproject.model.Course;
import com.mappingproject.repository.CourseRepository;
@Service
public class CourseServiceImpl implements CourseAndInstructorService<Course> {

	@Autowired
	CourseRepository courseRepository;
	
	@Override
	public void saveEntities(Course course) {
		courseRepository.save(course);
		
	}

	@Override
	public void deleteEntities(Course course) {
		// TODO Auto-generated method stub
		courseRepository.deleteById(course.getId());;
		
	}

}
