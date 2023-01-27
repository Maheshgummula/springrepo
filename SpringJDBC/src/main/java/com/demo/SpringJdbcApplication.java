package com.demo;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.dao.EmployeeDao;
import com.demo.entity.Employee;

//@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {
//		SpringApplication.run(SpringJdbcApplication.class, args);
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		EmployeeDao dao=(EmployeeDao)context.getBean("edao");
//		int status=dao.updateEmployee(new Employee(90, "Dinesh", "Bandra"));
//		int status=dao.saveEmployee(new Employee(3, "Aman", "Kandivili"));
//		int status=dao.deleteEmployee(new Employee(90));
//		System.out.println(status);
		List<Employee> employee=dao.showAll();
		for (Employee employee2 : employee) {
			System.out.println(employee2);
		}
	}

}