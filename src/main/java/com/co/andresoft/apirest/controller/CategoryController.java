package com.co.andresoft.apirest.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.andresoft.apirest.dto.CategoryDTO;
import com.co.andresoft.apirest.model.service.ICategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {

	@Autowired
	private ICategoryService categoryService;

	@PostMapping("/new-category")
	public ResponseEntity<?> addCategory(@Valid @RequestBody CategoryDTO categoryDTO){
		
		Map<String, Object> jsonResponseMap = new LinkedHashMap<String, Object>();
		
		categoryService.createCategory(categoryDTO);
		jsonResponseMap.put("message", "Category was created succesfully!");
		return new ResponseEntity<>(jsonResponseMap, HttpStatus.CREATED);
	}
	
}
