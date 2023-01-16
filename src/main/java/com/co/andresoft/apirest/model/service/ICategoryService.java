package com.co.andresoft.apirest.model.service;

import java.util.List;

import com.co.andresoft.apirest.dto.CategoryDTO;
import com.co.andresoft.apirest.model.entity.Category;

public interface ICategoryService {
	
	public List<CategoryDTO> findAllCategories();
	
	public Category findCategoryById(Long id);
	
	public CategoryDTO getCategoryById(Long id);
	
	public CategoryDTO createCategory(CategoryDTO categoryDTO);
	
	public CategoryDTO updateCategoryById(Long id, CategoryDTO categoryDTO);
	
	public void deleteCategoryById(Long id);
}
