package com.urlshortner.controller;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.urlshortner.entity.Urlshortner;
import com.urlshortner.service.UrlService;

@RestController
public class UrlController {
	@Autowired
	UrlService service;
	
	@Value("${app.title}")
	  private String appTitle;
	
	@PostMapping("/savingurl")
	public ResponseEntity<?> saving(@RequestBody Urlshortner urlshortner){
		
		Urlshortner urlshortner2=service.savingUrl(urlshortner);
		if (urlshortner2!=null) {		
			return new ResponseEntity<Urlshortner>(urlshortner2, HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@PostMapping("/savingfromjdbc")
	public ResponseEntity<?> savingd(@RequestBody Urlshortner urlshortner){
		
		int i=service.save(urlshortner);
			
			return new ResponseEntity<Integer>(i, HttpStatus.OK);
		
		
	}
	@GetMapping("/getOriginalUrl/{newUrl}")
	public ResponseEntity<?> getOriginalUrl(@PathVariable String newUrl){
		return new ResponseEntity<>(service.getOringinal(newUrl), HttpStatus.OK);
	}
	
	
	@GetMapping("/getOriginalUrlss/{newUrl}")
	public void getOriginalUrls(@PathVariable String newUrl,HttpServletResponse response){
		String url=service.getOringinal(newUrl);
		try {
			response.sendRedirect(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@PostConstruct
	  public void startApplication() {
	      System.out.printf("-- running application: %s --%n", appTitle);

	  }

	
}
