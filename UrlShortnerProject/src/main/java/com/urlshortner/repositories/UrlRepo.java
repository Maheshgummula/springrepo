package com.urlshortner.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.urlshortner.entity.Urlshortner;
@Repository
public interface UrlRepo extends CrudRepository<Urlshortner, Integer> {
	
	@Query(value = "select original_url from urlshortner where new_url=?1",nativeQuery = true)
	public String getOriginalUrl(String newUrl);
	
	

}
