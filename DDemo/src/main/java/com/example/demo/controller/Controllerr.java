package com.example.demo.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmpService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

@RestController
public class Controllerr {

	@Autowired
	private EmpService service;
	
	
	@Value("${server.port}")
	String val;

	@GetMapping("/getAllList")
	public List<Employee> list() {
		return service.list();
	}

	@GetMapping("/getstring")
	public String getString() {
		return "Hii Mahesh";
	}
	@GetMapping(value  ="/get" ,produces = "application/json")
	public String getting() throws  IOException {
		RestTemplate template=new RestTemplate();
	
		String str=template.getForObject("http://localhost:"+this.val+"/v3/api-docs", String.class);
		FileWriter file = new FileWriter("D:/output.json");

        file.write(str);
        file.close();
		return str;
		
	}
//	
//	@GetMapping(value  ="/getfromactuator" ,produces = "application/json")
//	public String getFromActuator() throws  IOException, JSONException {
//		RestTemplate template=new RestTemplate();
//		
//		String str=template.getForObject("http://localhost:"+this.val+"/actuator/mappings", String.class);
//		FileWriter file = new FileWriter("D:/actuatorsdata.json");
////		JSONObject object=new JSONObject(str);
//		String obj=new String(str);
//		Gson gson=new Gson();
////		ObjectMapper mapper=new ObjectMapper();
////		mapper.writeValue(Paths.get("D:/AAAAAAAAAA.json").toFile(), obj);
////		JsonObject object=gson.toJson(str,new FileWriter("D:/Acutttttttttttt.json);
//				JsonObject object=gson.toJson(obj,JsonObject.class);
//		
//		file.write(str);
//		file.close();
//		return str;
//		
//	}

}
