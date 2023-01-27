package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Student;

public interface Studentservice {
	public List<Student> getAllStudents();
	public Student addStudent(Student student);
	
	public String deleteStudent(int id);
	public Student updateStudent(int id);
	public boolean getStudent(int id);
	
	
}
