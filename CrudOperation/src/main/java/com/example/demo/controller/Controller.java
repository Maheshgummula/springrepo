package com.example.demo.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.json.JsonObject;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Post;
import com.fasterxml.jackson.core.JsonParser;
import com.google.gson.Gson;

import netscape.javascript.JSObject;

@RestController
@RequestMapping("/Student")
public class Controller {
//	@Autowired
//	RestTemplate template;
	
	@Value("${server.port}")
	String val;
	
	@Autowired
	Myclass myclass;
	
	
	@GetMapping("/get")
	public String getting() throws ParseException, IOException {
		RestTemplate template=new RestTemplate();
	
		String str=template.getForObject("http://localhost:"+this.val+"/v3/api-docs", String.class);
//		Gson gson=new Gson();
//		JSObject object=gson.fromJson(str, JSObject.class);
//		JSONParser parser=new JSONParser();
//		JSONObject object=(JSONObject) parser.parse(str);
		
//		String str=template.getForObject("https://jsonplaceholder.typicode.com/posts", String.class);
//		System.out.println(object);
		FileWriter file = new FileWriter("D:/output.json");
//        String datas =  template.getForObject(object,String.class);
//        System.out.println("data was : " + datas);
        file.write(str);
        file.close();
       // myclass.onApplicationEvent();
		return null;
		
	}
	
	
	
//	@Value("${resourceUrl}")
//	private String url;
//	@GetMapping(value = "/get/{id}",produces = "application/json")
//	public String getStudents(@PathVariable int id ){
////		RestTemplate template=new RestTemplate();
//		String str= template.getForObject(this.url+"/"+id, String.class);
//		return  str;
//	}
//	@GetMapping(value = "/allstudent")
//	public ResponseEntity<List> get() {
////		RestTemplate template=new RestTemplate();
//		ResponseEntity<List> entity=template.getForEntity(this.url, List.class);
//		return entity;
//	}
//	@GetMapping(value = "/exchange/{id}",produces = "application/json" )
//	public String exchanges (@PathVariable int id) {
////		RestTemplate restTemplate=new RestTemplate();
//		HttpHeaders headers=new HttpHeaders();
//		HttpEntity httpEntity=new HttpEntity(headers);
//		ResponseEntity<String> responseEntity=template.exchange(this.url+"/"+id, HttpMethod.GET, httpEntity, String.class);
//		return responseEntity.getBody();
//	}
//	
//	@PostMapping(value = "/post")
//	public Post dopost(@RequestBody Post post){
////		String url="https://jsonplaceholder.typicode.com/posts/";
////		RestTemplate restTemplate=new RestTemplate();
//		ResponseEntity<Post> entity=template.postForEntity(this.url+"/", post, Post.class);
//		return  entity.getBody();
//	}
//	
//	@PostMapping(value = "/posting",produces = "application/json")
//	public Post doposting(@RequestBody Post post){
////		RestTemplate restTemplate=new RestTemplate();
//         Post entity=template.postForObject(this.url+"/", post, Post.class);
//		return  entity;
//	}
//	
//	
//
}
