package com.example.demo.exceptionhandler;

public class StudentAlreadyExists extends RuntimeException {
	public StudentAlreadyExists(String msg) {
		super(msg);
	}
	

}
