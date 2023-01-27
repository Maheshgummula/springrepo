package com.paginationexample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.paginationexample.entity.PageDetails;
import com.paginationexample.entity.Post;
import com.paginationexample.repository.PostRepository;

@Service
public class PostServiceImpl {
	
	
	@Autowired
	PostRepository postRepository;

	public Post save(Post post)
	{
		return (Post) postRepository.save(post);
	}
	
	public List<Post> getPagination(PageDetails details) {
		Pageable pageable=PageRequest.of(details.getPageNo()-1, details.getPageSize());
		Page<Post> page=postRepository.findAll(pageable);
		return page.toList();
	}
}
