package com.imageviewer.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.imageviewer.entity.ImageEntity;
import com.imageviewer.repository.ImageViewerRepository;


@Service
public class ImageViewerServiceImpl {
	@Autowired
	ImageViewerRepository repository;
	
	public String uploadImage(String path,MultipartFile file,ImageEntity entity) throws IOException {
		
		String name=file.getOriginalFilename();
		entity.setPhoto("images/"+name);
		repository.save(entity);
		
//		String randomUID=UUID.randomUUID().toString();
//		String fileNameWithRandom=randomUID.concat(name.substring(name.lastIndexOf(".")));
		
		String filePath=path+File.separator+name;
		File myfile=new File(path);
		if (!myfile.exists()) {
			myfile.mkdir();
		}
		Path files=Paths.get(filePath);
		Files.write(files, file.getBytes());
		return name;
	}
	
	public ImageEntity getById(Integer id) {
		Optional<ImageEntity> db=repository.findById(id);
		return db.get();
	}

}
