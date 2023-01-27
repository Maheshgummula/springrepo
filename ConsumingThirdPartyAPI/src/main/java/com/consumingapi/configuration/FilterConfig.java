package com.consumingapi.configuration;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.consumingapi.filter.CustomFilter;
import com.consumingapi.filter.ReaderClass;


public class FilterConfig {
	@Bean
	public FilterRegistrationBean<CustomFilter> get(){
		FilterRegistrationBean< CustomFilter> bean=new FilterRegistrationBean<>();
		CustomFilter filter=new CustomFilter();
		bean.setFilter(filter);
		bean.addUrlPatterns("/*");
		return bean;
	}
}
