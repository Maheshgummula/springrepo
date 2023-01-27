package com.mappingproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mappingproject.model.Course;
import com.mappingproject.model.Instructor;
import com.mappingproject.repository.InstructorRepository;
@Service
public class InstructorServiceImpl implements CourseAndInstructorService<Instructor> {

	@Autowired
	InstructorRepository repository;
	
	@Override
	public void saveEntities(Instructor t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEntities(Instructor t) {
		// TODO Auto-generated method stub
		
	}
	
	public List<Course> get(Long id) {
	return	repository.findById(id).get().getCourse();
	}

}
