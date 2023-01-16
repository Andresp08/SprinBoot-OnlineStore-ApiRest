package com.co.andresoft.apirest.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	private final Map<String, Object> jsonResponseMap = new LinkedHashMap<String, Object>();
	
	@GetMapping("/get-categories")
	public List<CategoryDTO> getAllCategories(){
		return categoryService.findAllCategories();
	}
	
	@GetMapping("/get-category/{id}")
	public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable(name = "id") Long id) {
		
		CategoryDTO categoryDTO = categoryService.getCategoryById(id);
		
		return new ResponseEntity<>(categoryDTO, HttpStatus.OK);
	}

	@PostMapping("/new-category")
	public ResponseEntity<Object> addCategory(@Valid @RequestBody CategoryDTO categoryDTO){
		
		categoryService.createCategory(categoryDTO);
		
		jsonResponseMap.put("status", "Ok");
		jsonResponseMap.put("message", "Category was created succesfully!");
		return new ResponseEntity<>(jsonResponseMap, HttpStatus.CREATED);
	}
	
	@PutMapping("/update-category/{id}")
	public ResponseEntity<Object> updateCategory(@PathVariable(name = "id") Long id,
			@Valid @RequestBody CategoryDTO categoryDTO){
		
		categoryService.updateCategoryById(id, categoryDTO);
		
		jsonResponseMap.put("status", "Ok");
		jsonResponseMap.put("message", "Category created succesfully!");
		
		return new ResponseEntity<>(jsonResponseMap, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete-category/{id}")
	public ResponseEntity<Object> deleteCategory(@PathVariable(name = "id") Long id){
		categoryService.deleteCategoryById(id);
		
		jsonResponseMap.put("status", "Ok");
		jsonResponseMap.put("message", "Category deleted succesfully!");
		
		return new ResponseEntity<>(jsonResponseMap, HttpStatus.OK);
	}
	
}
