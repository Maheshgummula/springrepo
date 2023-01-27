package com.example.demo.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.filters.CustomFilter;

@Configuration
public class FilterConfig {
	
	private final Logger logger=LoggerFactory.getLogger(FilterConfig.class);
      @Bean
	public FilterRegistrationBean<CustomFilter> getRegistredBean() {
		FilterRegistrationBean<CustomFilter> bean=new FilterRegistrationBean<>();
		CustomFilter filter=new CustomFilter();
		bean.setFilter(filter);
		bean.addUrlPatterns("/student/*");
		bean.setOrder(1);
		return bean;
		
	}
      
//      @Bean
//      public PasswordEncoder getEncode() {
//    	  logger.info("Password Encoder is used");
//    	  return NoOpPasswordEncoder.getInstance();
//      }
      
     
    	  
    	  

	
}
