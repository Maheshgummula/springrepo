package com.urlshortner.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.urlshortner.entity.Urlshortner;
@Repository
public class UrlRepositoryClass implements JdbcTemplateRepository{

	@Autowired
	JdbcTemplate template;
	
	@Override
	public int save(Urlshortner urlshortner) {
		// TODO Auto-generated method stub
		return template.update("insert into urlshortner (new_url,original_url) values(?,?)",urlshortner.getNewUrl(),urlshortner.getOriginalUrl());
	}

	@Override
	public String getOriginal(String newUrl) {
		// TODO Auto-generated method stub
		return template.queryForObject("select original_url from urlshortner where new_url=?",new String[]{newUrl},String.class) ;
	}

}
