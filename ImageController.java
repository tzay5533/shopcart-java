package com.spring.webapp.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.webapp.models.Category;
import com.spring.webapp.models.ImageModel;
import com.spring.webapp.service.CategoryService;
import com.spring.webapp.service.ImageService;

@Controller
public class ImageController {

	private ImageService imageService;

	public ImageController(ImageService imageService) {
		this.imageService = imageService;
	}
	
	@RequestMapping("/images")
	public String findImages(Model model){
		
		List<ImageModel> images = imageService.getAll();
		
		model.addAttribute("images",images);
		
		return "image-list";
		
	}
	@RequestMapping("/image/{id}")
	public String getImageModelInfo(@PathVariable long id,Model model){
		
		ImageModel image = imageService.findById(id);
		
		model.addAttribute("image",image);
		
		return "image-info";

	}
	
}
