package com.imageviewer.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.imageviewer.entity.FileResponse;
import com.imageviewer.entity.ImageEntity;
import com.imageviewer.service.ImageViewerServiceImpl;

@Controller
public class ImageViewerController {

	@Autowired
	ImageViewerServiceImpl impl;
		
	
	@GetMapping("/index")
	public String getIndexPage() {
		return "Index";
	}
	@GetMapping("/GetImagePage")
	public String getImagePage() {
		return "GetImages";
	}
	
	
	@PostMapping("/upload")
	public String upload(@RequestParam("image") MultipartFile image,Model model,ImageEntity entity) throws IOException{
//			String  uploadPath=new ClassPathResource("resources/images").getFile().getAbsolutePath();
		String uploadPath="C:\\Users\\Mahesh.Gummula\\spring-workspace\\ImageViewer\\src\\main\\resources\\static\\images";
		String filename = impl.uploadImage(uploadPath, image,entity);
		model.addAttribute("Message", "Image Uploaded");
		return "Index";
		
	}
	
	@GetMapping("/getImage")
	public String getImageByName(@RequestParam(value = "id") Integer id,Model model) {
		System.out.println(id);
		
		ImageEntity m=impl.getById(id);
		System.out.println(m.getPhoto());
		model.addAttribute("Image",m.getPhoto());
		
		return "GetImages";
	}
}
