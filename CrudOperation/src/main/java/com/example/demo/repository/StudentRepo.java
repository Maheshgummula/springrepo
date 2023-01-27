package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Student;
@Transactional
@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {
	
	@Query(value = "delete from student where name=?1",nativeQuery = true)
	public void delete(String name); 

}
