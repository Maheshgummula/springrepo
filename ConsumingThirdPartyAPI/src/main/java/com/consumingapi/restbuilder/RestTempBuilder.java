package com.consumingapi.restbuilder;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.consumingapi.interceptors.MyInterceptorHandler;

@Configuration
public class RestTempBuilder {

	@Bean
	public MyInterceptorHandler getInterceptor() {
		return new MyInterceptorHandler();
	}
	@Bean
	public RestTemplate getRestTemplate() {
		ClientHttpRequestFactory factory=new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory());
		RestTemplate template=new RestTemplate(factory);
		template.setInterceptors(Collections.singletonList(getInterceptor()));
		return template;
	}
}
