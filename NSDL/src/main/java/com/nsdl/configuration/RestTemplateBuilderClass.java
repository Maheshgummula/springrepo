package com.nsdl.configuration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateBuilderClass {

	@Bean
	public RestTemplate getRestTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
}
