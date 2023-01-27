package com.paginationexample.cotroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.paginationexample.entity.PageDetails;
import com.paginationexample.entity.Post;
import com.paginationexample.service.PostServiceImpl;

@RestController
public class PostController {
	
	
	@Autowired
	PostServiceImpl impl;
	@Autowired
	private RestTemplate template;
	

	@Value("${resourceUrl}")
	private String url;
	
	@GetMapping(value ="/getAllPosts")
	public List<Post> getAllPosts(){
		HttpHeaders  headers=new HttpHeaders();
		HttpEntity entity=new HttpEntity(headers);
		ResponseEntity<List> postobj=template.exchange(url, HttpMethod.GET,entity, List.class);
		return postobj.getBody();
	}
//	@GetMapping(value ="/getAllPosts")
//	public Post[] getAllPosts(){
//		Post[] postobj=template.getForObject(this.url, Post[].class);
//		return postobj;
//	}
//	@GetMapping("/getAllPosts")
//	public ResponseEntity<List> getAllPosts(){
//		ResponseEntity<List>  post= template.getForEntity(this.url, List.class);
//		return post;
//	}
	@PostMapping("/save")
	public ResponseEntity<Post> save(@RequestBody Post post){	
		return new ResponseEntity<Post>(impl.save(post), HttpStatus.CREATED);
	}
	
	@GetMapping("/pagination")
	public ResponseEntity<List<Post>> getPagination(@RequestBody PageDetails details){
		return new  ResponseEntity<List<Post>>(impl.getPagination(details), HttpStatus.FOUND);
	}


}
