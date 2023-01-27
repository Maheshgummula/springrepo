package com.bitlyexample.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bitlyexample.entity.ExpandEntity;
import com.bitlyexample.entity.RequestForShorten;
import com.bitlyexample.entity.TokenEncryptRequest;
import com.bitlyexample.service.EncryptDecryptServiceImpl;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@RestController
public class BitlyController {

	@Autowired
	RestTemplate template;
	
	@Value("${my.uri}")
	private String url;
	
	@Value("${expand.url}")
	private String Expandurl;
	
	@Value("${get.organizationid}")
	private String organizationurl;
	
	@Value("${get.groupid}")
	private String groupurl;
	
	@Autowired
	private EncryptDecryptServiceImpl impl;
	
	
	@PostMapping(value="/shortingUrl",produces = MediaType.APPLICATION_JSON_VALUE)
	public Object shortingUrl(@RequestBody RequestForShorten entity,HttpServletRequest request)
	{
		//Getting Organization Id
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", "Bearer 824ad66d97032d0f7b1d1eea843726e4c96fd89e");
		HttpEntity<Object> myentity=new HttpEntity(headers);
		ResponseEntity<String> organizationdata=template.exchange(organizationurl,HttpMethod.GET, myentity,String.class);
		JsonParser parser=new JsonParser();
		JsonObject jsonObject=(JsonObject) parser.parse(organizationdata.getBody());
		JsonArray array=jsonObject.getAsJsonArray("organizations");
		JsonObject organizationobj=new JsonObject();
		for (int i = 0; i < array.size(); i++) {
			 organizationobj=(JsonObject) array.get(i);
		}
		//Getting Group Id
		String organizationId=organizationobj.get("guid").getAsString();
		ResponseEntity<String> groupdata=template.exchange(groupurl+organizationId,HttpMethod.GET, myentity,String.class);

		
		JsonObject StringToJsonObject=(JsonObject) parser.parse(groupdata.getBody());
		JsonArray grouparray=StringToJsonObject.getAsJsonArray("groups");
		JsonObject groupObj=new JsonObject();
		for (int i = 0; i < grouparray.size(); i++) {
			groupObj=(JsonObject) grouparray.get(i);
		}
		String groupId=groupObj.get("guid").getAsString();
		
		//Shorting
		entity.setGroup_guid(groupId);
		HttpEntity<Object> entityforshorten=new HttpEntity(entity,headers);
		ResponseEntity<Object> responseEntity=template.postForEntity(url, entityforshorten,  Object.class);		
		return responseEntity.getBody();
////		return array.getAsString();
		
		
		
//		return groupdata.getBody();
		
	}//"Bearer 824ad66d97032d0f7b1d1eea843726e4c96fd89e"
	
//	Ombe6ZNUHZA organization_id
//	Bmbe6LNNBwX group Id
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@PostMapping(value="/shortingUrl",produces = MediaType.APPLICATION_JSON_VALUE)
//	public Object shortingUrl(@RequestBody RequestForShorten entity,HttpServletRequest request)
//	{
////		System.out.println("1111111111111111111111");
////		HttpHeaders headers=new HttpHeaders();
////		headers.setContentType(MediaType.APPLICATION_JSON);
////		headers.set("Authorization", "Bearer 824ad66d97032d0f7b1d1eea843726e4c96fd89e");
////		HttpEntity<Object> myentity=new HttpEntity(headers);
////		
////		String organizationdata=template.exchange(organizationurl,myentity,, String.class);
////		System.out.println("2222222222222222222222");
////		JsonParser parser=new JsonParser();
////		JsonObject jsonObject=(JsonObject) parser.parse(organizationdata);
////		JsonElement array=jsonObject.get("organizations");
////		
////		System.out.println(array.getAsString());
//		
//		String token=request.getHeader("Authorization");
//		System.out.println("Token from controller"+token);
//		HttpHeaders headers=new HttpHeaders();
//		headers.setContentType(MediaType.APPLICATION_JSON);
//		headers.set("Authorization", token);
////		
//		HttpEntity<Object> myentity=new HttpEntity(entity,headers);
//		ResponseEntity<Object> responseEntity=template.postForEntity(url, myentity,  Object.class);
//	
//	return responseEntity.getBody();
////	return array.getAsString();
//		
//		
//	}//"Bearer 824ad66d97032d0f7b1d1eea843726e4c96fd89e"
//	
////	Ombe6ZNUHZA organization_id
////	Bmbe6LNNBwX group Id
	
	@PostMapping(value="/originalUrl",produces = MediaType.APPLICATION_JSON_VALUE)
	public Object OriginalUrl(@RequestBody ExpandEntity entity,HttpServletRequest request){
		
		String token=request.getHeader("Authorization");
		
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", token);
		HttpEntity<Object> myentity=new HttpEntity(entity,headers);
		ResponseEntity<Object> responseEntity=template.postForEntity(Expandurl, myentity,  Object.class);
		
		return responseEntity.getBody();
	}

	

	@PostMapping(value ="/encrypt",produces = "application/json")
	public String encrypting(@RequestBody TokenEncryptRequest model) {
	return impl.encryptRequest(model.getToken());
	}
	@PostMapping(value = "/decrypt",produces = "application/json")
	public String decrypting(@RequestBody TokenEncryptRequest model) {
		return impl.decryptMessage(model.getToken());
	}
	
	
	
//	@PostMapping("/shortingUrl")
//	public ResponseEntity<String> shortingUrl(@RequestBody RequestEntity entity){
//		
//		String shorten=Bit.ly("824ad66d97032d0f7b1d1eea843726e4c96fd89e").shorten(entity.getUrl());
//		
//		return new ResponseEntity<String>(shorten, HttpStatus.OK);
//	}
//	
//	@PostMapping("/originalUrl")
//	public ResponseEntity<String> OriginalUrl(@RequestBody RequestEntity entity){
//		
//		String originalUrl=Bit.ly("824ad66d97032d0f7b1d1eea843726e4c96fd89e").expand(entity.getUrl());
//		
//		return new ResponseEntity<String>(originalUrl, HttpStatus.OK);
//	}
	
//	http://localhost:8080/swagger-ui/index.html#/url-shorting-controller/generateShortLink
//.proxyUri("http://localhost:8080").proxyUsername("mahesh123098").proxyPassword("Maheshg@123")
}
