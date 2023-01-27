package com.mappingproject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mappingproject.model.Course;
import com.mappingproject.service.CourseAndInstructorService;
import com.mappingproject.service.InstructorServiceImpl;

@RestController
public class Controller {

	@Autowired
	CourseAndInstructorService<Course> courseAndInstructorService;

	@Autowired
	InstructorServiceImpl impl;
	
	@PostMapping("/saveCourse")
	public ResponseEntity<?> saveCourse(@RequestBody Course course){
		courseAndInstructorService.saveEntities(course);
	 return	new ResponseEntity<String>("Done!!!", HttpStatus.OK);
	}
	@GetMapping("/getCourseOfInstructor/{id}")
	public ResponseEntity<List<Course>> get(@PathVariable Long id){
		return new ResponseEntity<List<Course>>(impl.get(id),HttpStatus.FOUND);
		
	}
	@DeleteMapping("/delete")
	public void delete(@RequestBody Course course){
		courseAndInstructorService.deleteEntities(course);
		
	}
}
