package com.co.andresoft.apirest.model.service;

import com.co.andresoft.apirest.dto.CategoryDTO;
import com.co.andresoft.apirest.model.entity.Category;

public interface ICategoryService {

	public CategoryDTO createCategory(CategoryDTO categoryDTO);
	
	public Category findCategoryById(Long id);
}
