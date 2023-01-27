package com.mappingproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mappingproject.model.Address;
import com.mappingproject.model.Student;
import com.mappingproject.repository.AddressRepository;
import com.mappingproject.service.StudentServiceImpl;

@RestController
@RequestMapping(value = "/student")
public class StudentController {
	@Autowired
	private StudentServiceImpl serviceImpl;
	
	@Autowired
	private AddressRepository addressRepository;
	
 public StudentServiceImpl getServiceImpl() {
		return serviceImpl;
	}
	
	@PostMapping(value = "/addStudent")
	public ResponseEntity<?> saveStudentObj(@RequestBody Student student){
		System.out.println(student);
		Student dbstudent =serviceImpl.saveStudent(student);
		if (dbstudent!=null) {
			return new ResponseEntity<>(dbstudent, HttpStatus.OK);	
		}else {			
			return new ResponseEntity<String>("Something went wrong!", HttpStatus.FORBIDDEN);
		}
	}
	
	@DeleteMapping(value = "/deleteStudentByName")
	public void deleteStudent(@RequestBody Student student) {
		serviceImpl.deleteStudent(student.getFirstname());
	}
	
	@DeleteMapping(value = "/deleteStudentAddress")
	public void deleteStudent(@RequestBody Address address) {
		serviceImpl.deleteStudentAddress(address.getId());
	}
	@DeleteMapping(value = "/deleteOnlyAddress")
	public void deleteAddress(@RequestBody Address address) {
		Address dbaddress=addressRepository.findById(address.getId()).get();
		dbaddress.getStudent().setAddress(null);//this will set Address to null in Student table
		
		addressRepository.delete(dbaddress);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getParentDetails(@PathVariable Long id){
		
//		if (addressRepository.findById(id).isPresent()) {
//			
//			return new ResponseEntity<>(addressRepository.findById(id).get(), HttpStatus.FOUND);
			return new ResponseEntity<>(serviceImpl.get(id), HttpStatus.FOUND);
//		}
//		else {
//			return null;
//		}
		
	}
}
