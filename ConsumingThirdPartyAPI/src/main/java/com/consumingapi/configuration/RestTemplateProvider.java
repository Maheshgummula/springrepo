package com.consumingapi.configuration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
//@Configuration
public class RestTemplateProvider {
@Bean	
public RestTemplate getRestTemplate(RestTemplateBuilder builder) {
	return builder.build();
}
}
