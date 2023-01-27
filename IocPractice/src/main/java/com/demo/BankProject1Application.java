package com.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.entity.Anything;
import com.demo.entity.Student;

//@SpringBootApplication
public class BankProject1Application {

	public static void main(String[] args) {
//		ApplicationContext context=SpringApplication.run(BankProject1Application.class, args);
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
//		Student s=(Student)context.getBean("studentob");
//		System.out.println(s);
		Anything anything=context.getBean("anything", Anything.class);
		anything.allMethods();
	}

}
