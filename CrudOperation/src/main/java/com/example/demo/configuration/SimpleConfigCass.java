package com.example.demo.configuration;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.filters.SimpleFilter;
//@Configuration
public class SimpleConfigCass {
	 @Bean
     public FilterRegistrationBean<SimpleFilter> getSimpleFilter() {
		// TODO Auto-generated method stub
   	  FilterRegistrationBean<SimpleFilter> bean=new FilterRegistrationBean<>();
   	  SimpleFilter filter=new SimpleFilter();
   	  bean.setFilter(filter);
 		bean.addUrlPatterns("/getstudents");
 		bean.setOrder(2);
 		return bean;

}
}