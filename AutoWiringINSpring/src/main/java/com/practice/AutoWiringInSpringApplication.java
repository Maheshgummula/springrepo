package com.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.practice.entity.Student;

//@SpringBootApplication
public class AutoWiringInSpringApplication {

	public static void main(String[] args) {
//		SpringApplication.run(AutoWiringInSpringApplication.class, args);
		ApplicationContext context=new ClassPathXmlApplicationContext("web.xml");
		Student student=(Student) context.getBean("studentBean");
		student.showDetails();
	}

}
