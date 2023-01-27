package com.email;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
@EnableScheduling
@SpringBootApplication
public class EmailProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailProjectApplication.class, args);
	}

}
