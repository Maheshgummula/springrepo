package com.imageviewer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.imageviewer.entity.ImageEntity;

@Repository
public interface ImageViewerRepository extends CrudRepository<ImageEntity, Integer> {

	
}
