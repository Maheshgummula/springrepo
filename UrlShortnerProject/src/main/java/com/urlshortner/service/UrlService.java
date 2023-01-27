package com.urlshortner.service;

import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.hash.Hashing;
import com.urlshortner.entity.Urlshortner;
import com.urlshortner.repositories.UrlRepo;
import com.urlshortner.repositories.UrlRepositoryClass;

@Service
public class UrlService {
	@Autowired
	UrlRepo repo;
	
	@Autowired
	UrlRepositoryClass class1;
	
	public Urlshortner savingUrl(Urlshortner urlshortner) {
		String newUrl=Hashing.murmur3_32().hashString(urlshortner.getOriginalUrl(), StandardCharsets.UTF_8).toString();
		urlshortner.setNewUrl(newUrl);
		return   repo.save(urlshortner);
	}
	
	public String getOringinal(String newUrl) {
		return repo.getOriginalUrl(newUrl);
	}
	
	public int save(Urlshortner urlshortner) {
		String newUrl=Hashing.murmur3_32().hashString(urlshortner.getOriginalUrl(), StandardCharsets.UTF_8).toString();
		urlshortner.setNewUrl(newUrl);
		return class1.save(urlshortner);
	}

}
