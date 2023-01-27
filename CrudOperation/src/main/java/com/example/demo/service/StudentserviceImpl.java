package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepo;
@Service
public class StudentserviceImpl implements Studentservice {

	@Autowired
	private StudentRepo repo;
	
	@Override
	public List<Student> getAllStudents() {
		return repo.findAll();
	}

	@Override
	public Student addStudent(Student student) {
	
		return repo.save(student);
		
	}

	@Override
	public String deleteStudent(int id) {
		
		 repo.deleteById(id);
		 return "deleted succesfully";
		 
	}

	@Override
	public Student updateStudent(int id) {
		return repo.findById(id).get();
	}
@Override
public boolean getStudent(int id) {
	// TODO Auto-generated method stub
	return repo.existsById(id);
}
}
