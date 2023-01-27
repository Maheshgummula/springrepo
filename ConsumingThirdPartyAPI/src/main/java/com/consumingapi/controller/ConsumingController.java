package com.consumingapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.consumingapi.models.AadharEntity;
import com.consumingapi.models.InfoEntity;
import com.consumingapi.models.RequestData;
import com.consumingapi.service.EncryptDecryptServiceImpl;

@RestController
public class ConsumingController {
	@Value("${consumeapi.link}")
	String url;
	
	@Value("${pan.url}")
	String panurl;
	
	@Value("${voter.id}")
	String voterurl;
	
	@Value("${aadhar.otp}")
	String aadharOtpurl;
	
	@Value("${submit.aadhar.otp}")
	String submitUrl;
	
	@Value("${my.url}")
	String myurl;
	

	@Autowired
	RestTemplate template;
	
	@Autowired
	EncryptDecryptServiceImpl impl;

	@PostMapping(value = "/postForPanCard")
	public ResponseEntity<String> getApi(@Valid @RequestBody InfoEntity model) {
		if (model.getId_number() != null) {
			HttpHeaders headers = new HttpHeaders();
			headers.set("Authorization",
					"Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJmcmVzaCI6ZmFsc2UsImlhdCI6MTY2MjcwNDE5MywianRpIjoiYWQ5ZWNkYTItNDY0Mi00MGY3LTgxOTEtNjc5MmZjZjQ0MmNmIiwidHlwZSI6ImFjY2VzcyIsImlkZW50aXR5IjoiZGV2LnRla25vcG9pbnRAc3VyZXBhc3MuaW8iLCJuYmYiOjE2NjI3MDQxOTMsImV4cCI6MTY2NTI5NjE5MywidXNlcl9jbGFpbXMiOnsic2NvcGVzIjpbIndhbGxldCJdfX0.Ow5gV6Di7vddH_LwWlWXhT8bRhUH7dGCxPf_G4tENHI");
			HttpEntity<Object> entity = new HttpEntity<>(model,headers);
//			ResponseEntity<String> response=template.exchange(url+"/api/v1/pan/pan",HttpMethod.POST,entity,String.class);
			ResponseEntity<String> response = template.postForEntity(url + panurl, entity, String.class);
			return response;
		}else {
			return ResponseEntity.ok("please Enter all details");
		}

	}
	
	@PostMapping(value = "/postForVoterId")
	public ResponseEntity<String> getVoterId(@Valid @RequestBody InfoEntity  model){
		if (model.getId_number()!=null) {
			HttpHeaders headers = new HttpHeaders();
			headers.set("Authorization",
					"Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJmcmVzaCI6ZmFsc2UsImlhdCI6MTY2MjcwNDE5MywianRpIjoiYWQ5ZWNkYTItNDY0Mi00MGY3LTgxOTEtNjc5MmZjZjQ0MmNmIiwidHlwZSI6ImFjY2VzcyIsImlkZW50aXR5IjoiZGV2LnRla25vcG9pbnRAc3VyZXBhc3MuaW8iLCJuYmYiOjE2NjI3MDQxOTMsImV4cCI6MTY2NTI5NjE5MywidXNlcl9jbGFpbXMiOnsic2NvcGVzIjpbIndhbGxldCJdfX0.Ow5gV6Di7vddH_LwWlWXhT8bRhUH7dGCxPf_G4tENHI");
			HttpEntity<Object> entity = new HttpEntity<>(model,headers);
			ResponseEntity<String> response = template.postForEntity(url + voterurl, entity, String.class);
			return response;
		}
		return null;
	}
	
	@PostMapping(value = "/aadharOtpGenerate")
	public ResponseEntity<String> getAadharOtp(@Valid @RequestBody InfoEntity  model){
		if (model.getId_number()!=null) {
			HttpHeaders headers = new HttpHeaders();
			headers.set("Authorization",
					"Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJmcmVzaCI6ZmFsc2UsImlhdCI6MTY2MjcwNDE5MywianRpIjoiYWQ5ZWNkYTItNDY0Mi00MGY3LTgxOTEtNjc5MmZjZjQ0MmNmIiwidHlwZSI6ImFjY2VzcyIsImlkZW50aXR5IjoiZGV2LnRla25vcG9pbnRAc3VyZXBhc3MuaW8iLCJuYmYiOjE2NjI3MDQxOTMsImV4cCI6MTY2NTI5NjE5MywidXNlcl9jbGFpbXMiOnsic2NvcGVzIjpbIndhbGxldCJdfX0.Ow5gV6Di7vddH_LwWlWXhT8bRhUH7dGCxPf_G4tENHI");
			HttpEntity<Object> entity = new HttpEntity<>(model,headers);
			ResponseEntity<String> response = template.postForEntity(url + aadharOtpurl, entity, String.class);
			return response;
		}
		return null;
	}
	
	@PostMapping(value = "/submitAadharOtp")
	public ResponseEntity<String> getSubmitAadharOtp(@Valid @RequestBody AadharEntity  model){
		if (model.getClient_id()!=null && model.getOtp()!=null) {
			HttpHeaders headers = new HttpHeaders();
			headers.set("Authorization",
					"Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJmcmVzaCI6ZmFsc2UsImlhdCI6MTY2MjcwNDE5MywianRpIjoiYWQ5ZWNkYTItNDY0Mi00MGY3LTgxOTEtNjc5MmZjZjQ0MmNmIiwidHlwZSI6ImFjY2VzcyIsImlkZW50aXR5IjoiZGV2LnRla25vcG9pbnRAc3VyZXBhc3MuaW8iLCJuYmYiOjE2NjI3MDQxOTMsImV4cCI6MTY2NTI5NjE5MywidXNlcl9jbGFpbXMiOnsic2NvcGVzIjpbIndhbGxldCJdfX0.Ow5gV6Di7vddH_LwWlWXhT8bRhUH7dGCxPf_G4tENHI");
			HttpEntity<Object> entity = new HttpEntity<>(model,headers);
			ResponseEntity<String> response = template.postForEntity(url + submitUrl, entity, String.class);
			return response;
		}
		return null;
	}
	@GetMapping(value = "/createKeys")
	public String getMethodName() {
//		impl.createKeys();
		return "Created Successfuly";
	}

	
	@PostMapping(value ="/encrypt",produces = "application/json")
	public String encrypting(@RequestBody String model) {
	return impl.encryptRequest(model);
	}
	@PostMapping(value = "/decrypt",produces = "application/json")
	public String decrypting(@RequestBody RequestData model) {
		System.out.println(model.getKey()+" just decrypting codeeeeeeeeeeeeeeeeeeeeeee");
		return impl.decryptMessage(model.getKey());
	}
	
	@GetMapping(value = "/allstudent")
	public ResponseEntity<List> get() {
		RestTemplate template1=new RestTemplate();
		ResponseEntity<List> entity=template1.getForEntity(this.myurl, List.class);
		return entity;
	}

}
