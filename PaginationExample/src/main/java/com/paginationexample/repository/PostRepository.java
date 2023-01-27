package com.paginationexample.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.paginationexample.entity.Post;

@Repository
public interface PostRepository extends PagingAndSortingRepository<Post, Integer>{

}
