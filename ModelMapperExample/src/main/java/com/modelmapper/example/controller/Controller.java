package com.modelmapper.example.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.modelmapper.example.entities.Student;
import com.modelmapper.example.entities.StudentDto;

@RestController
public class Controller {

	@Autowired
	ModelMapper mapper;
	
	@PostMapping(value = "studenttodto")
	public ResponseEntity<?> convertStudentToDto(@RequestBody Student student){
		StudentDto dto=mapper.map(student, StudentDto.class);
		return new ResponseEntity<StudentDto> (dto,HttpStatus.OK);
	}
	
	@PostMapping(value = "dtotostudent")
	public ResponseEntity<?> convertDtoToStudent(@RequestBody StudentDto dto){
		Student student  =mapper.map( dto,Student.class);
		return new ResponseEntity<Student> (student,HttpStatus.OK);
	}
}
