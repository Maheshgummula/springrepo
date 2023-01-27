package com.example.demo.exceptionhandler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//@Component
public class SchedularClass {
//@Scheduled(fixedDelay = 1000)
	void show() {
		
		for (int i = 0; i <=5; i++) {
			System.out.println(i);
		}
	}
	
	
}
