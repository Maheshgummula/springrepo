package com.mappingproject.service;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.mappingproject.model.Address;
import com.mappingproject.model.Student;
import com.mappingproject.repository.StudentRepository;
@Transactional
@Service
public class StudentServiceImpl {
	@Autowired
	 private StudentRepository repository;



public Student saveStudent(Student student) {
	return repository.save(student);
}

public void deleteStudent(String name) {
Student s=repository.findByFirstname(name);
	 repository.delete(s);
}
}
