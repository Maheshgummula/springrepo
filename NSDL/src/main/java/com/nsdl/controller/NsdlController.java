package com.nsdl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.nsdl.model.PanCard;
import com.nsdl.model.PanResponse;

@RestController
public class NsdlController {
	@Value("${url}")
	private String url;
	
	@Autowired
	RestTemplate template;
	
	@PostMapping("/postPan")
	public Object postPan(@RequestBody PanCard card){
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.set("developer_key", "becbbce45f79c6f5109f848acd540567");
		headers.set("secret-key", "MC6dKW278tBef+AuqL/5rW2K3WgOegF0ZHLW/FriZQw=");
		headers.set("secret-key-timestamp", "1516705204593");
		
		MultiValueMap<String, Object> map=new LinkedMultiValueMap<>();
		map.add("pan_number",card.getPanNumber());
		map.add("purpose", 1);
		map.add("initiator_id", "9971771929");
		map.add("purpose_desc", "onboarding");
		HttpEntity<Object> entity=new HttpEntity(map,headers);
		ResponseEntity<PanResponse> responseEntity =template.postForEntity(url, entity, PanResponse.class);
		return responseEntity.getBody();
	}

}
