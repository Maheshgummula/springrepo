package com.demo.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {
	@Modifying
	@Query(value =  "delete from student where contact=?1",nativeQuery = true)
	public void deleteByContact(Long contact);
	
	@Modifying
	@Query(value =  "update student set sname=?1,address=?2,fees=?3 where contact=?4",nativeQuery = true)
	public void updateByContact(String sname,String address,Double fees,Long contact);

	Student findByContact(Long contact);
}
