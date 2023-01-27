package com.consumingapi.interceptors;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import com.consumingapi.models.LoggerEntity;
import com.consumingapi.repository.LoggerRepository;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
@Component
public class MyInterceptorHandler implements ClientHttpRequestInterceptor{

	@Autowired
	LoggerRepository repository;
	
//	@Autowired
//	Pbkdf2PasswordEncoder encoder;
	
	private final Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {
		// TODO Auto-generated method stub
		LoggerEntity entity=new LoggerEntity();
		entity=logRequest(request, body);
		ClientHttpResponse response=execution.execute(request, body);
		logResponse(response,entity);
		return response;
	}
	public LoggerEntity logRequest(HttpRequest request,byte[] body)throws IOException {
		logger.info("************* Request Start **************");
		logger.info("URI         :{}",request.getURI());
		logger.info("HEADERS         :{}",request.getHeaders());
		logger.info("METHOD         :{}",request.getMethod());
		logger.info("Request Body         :{}",new String(body,"UTF-8"));
		logger.info("************* Request End **************");
		
		LoggerEntity entity=new LoggerEntity();
		String data=new String(body,"UTF-8");
		
		JsonObject object=new JsonParser().parse(data).getAsJsonObject();
		String id=object.get("id_number").getAsString();
		
		JsonObject object2=object.get("data").getAsJsonObject();
		String mobileno=object2.get("mobile").getAsString();
		entity.setRequest(id);
		entity.setResponsetimestamp(new Date().toString());
		entity.setMobile(mobileno);
		entity=repository.save(entity);
		return entity;
	}
	public void logResponse(ClientHttpResponse response ,LoggerEntity entity)throws IOException {
		logger.info("************* Response Start **************");
		logger.info("Status Code         :{}",response.getStatusCode());
		logger.info("Status Text         :{}",response.getStatusText());
		logger.info("HEADERS         :{}",response.getHeaders());
		logger.info("Response Body         :{}",StreamUtils.copyToString(response.getBody(), Charset.defaultCharset()));
		logger.info("************* Response End **************");
		entity.setRequesttimestamp(new Date().toString());
		entity.setResponse(StreamUtils.copyToString(response.getBody(), Charset.defaultCharset()));
		repository.save(entity);
	}
	
	
	

}
