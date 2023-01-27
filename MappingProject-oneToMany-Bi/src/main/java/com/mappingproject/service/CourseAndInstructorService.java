package com.mappingproject.service;

import org.springframework.stereotype.Service;

@Service
public interface CourseAndInstructorService<T> {
	
	public void saveEntities(T t);
	public void deleteEntities(T t);

}
