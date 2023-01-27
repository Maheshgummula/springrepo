package com.example.demo.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
@Component
public class Myclass implements ApplicationListener<ContextRefreshedEvent> {
Logger logger=LoggerFactory.getLogger(Myclass.class);
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// TODO Auto-generated method stub
		  ApplicationContext applicationContext =  event.getApplicationContext();
		    RequestMappingHandlerMapping requestMappingHandlerMapping = applicationContext
		        .getBean("requestMappingHandlerMapping", RequestMappingHandlerMapping.class);
		    Map<RequestMappingInfo, HandlerMethod> map = requestMappingHandlerMapping
		        .getHandlerMethods();
		    map.forEach((key, value) -> logger.info("{} {}", key, value));
		
	}


}
