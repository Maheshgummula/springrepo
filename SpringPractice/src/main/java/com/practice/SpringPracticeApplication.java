package com.practice;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.practice.entity.Student;

//@SpringBootApplication
public class SpringPracticeApplication {

	public static void main(String[] args) {
//		SpringApplication.run(SpringPracticeApplication.class, args);
		Resource resource=new ClassPathResource("web.xml");
		BeanFactory factory=new XmlBeanFactory(resource);
		Student s=(Student) factory.getBean("studentBean");
		System.out.println(s);
	}

}
