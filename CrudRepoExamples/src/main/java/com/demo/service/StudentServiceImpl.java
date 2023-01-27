package com.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.Student;
import com.demo.repository.StudentRepository;
@Service
@Transactional
public class StudentServiceImpl {
	@Autowired
	 StudentRepository repository;
	
	
	public void saveStudent(Student student) {
		repository.save(student);
	}

	public void deleteStudent(Long contact) {
		repository.deleteByContact(contact);	
	}
	public void updateStudent(Student student) {
		System.out.println(student);
		repository.updateByContact(student.getSname(),student.getAddress(),student.getFees(),student.getContact());	
	}
}
