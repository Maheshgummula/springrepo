package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepo;
import com.example.demo.service.StudentserviceImpl;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	StudentserviceImpl studentserviceImpl;
	
	@Autowired
	StudentRepo studentRepo;
	
	private static final Logger LOGGER=LoggerFactory.getLogger(Controller.class);
	@Autowired
	StudentRepo repo;
	
	@GetMapping("/getstudents")
	public List<Student> getStudents(){
		LOGGER.info("All clear");
		return studentserviceImpl.getAllStudents();
	}
	
	@PostMapping("/insert")
	public ResponseEntity<Student> addStudent(@RequestBody Student student) {
//		Student stud=studentserviceImpl.updateStudent(student.getId());
		if ((Integer)student.getId()!=null) {
			throw new RuntimeException("Student already exist!!!");
			
		}else {
			
			studentserviceImpl.addStudent(student);
			return new ResponseEntity<Student>(student,HttpStatus.OK);
		}
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable int id){
		try {
				String msg=studentserviceImpl.deleteStudent(id);
				return new ResponseEntity<String>(msg,HttpStatus.OK);
		
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Student> update(@RequestBody Student student,@PathVariable Integer id) {
		try {
		Student s=studentserviceImpl.updateStudent(id);
		if (s!=null) {
			s.setName(student.getName());
			s.setCity(student.getCity());
			repo.save(s);
			return new ResponseEntity<Student>(s,HttpStatus.OK);
		}
		else {
			throw new RuntimeException("Please check your Id number!!");
		}
		
		}catch (Exception e) {
return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}
	@DeleteMapping("/deleting")
	public ResponseEntity<String> deleting(@RequestBody String string){
		repo.delete(string);
		return new ResponseEntity<String>("deleted !", HttpStatus.OK);
	}

}
