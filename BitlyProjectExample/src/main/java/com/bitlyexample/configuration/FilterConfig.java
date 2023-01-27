package com.bitlyexample.configuration;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.bitlyexample.filter.BitlyFilter;


public class FilterConfig {
	@Bean
	public FilterRegistrationBean<BitlyFilter> get(){
		FilterRegistrationBean< BitlyFilter> bean=new FilterRegistrationBean<>();
		BitlyFilter filter=new BitlyFilter();
		bean.setFilter(filter);
		bean.addUrlPatterns("/*");
		return bean;
	}
}
