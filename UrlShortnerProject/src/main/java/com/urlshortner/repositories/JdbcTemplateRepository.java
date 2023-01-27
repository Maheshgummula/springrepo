package com.urlshortner.repositories;

import com.urlshortner.entity.Urlshortner;

public interface JdbcTemplateRepository {
public int save(Urlshortner urlshortner);
public String getOriginal(String newUrl);
}
