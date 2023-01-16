package com.co.andresoft.apirest.model.service.impl;


import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.co.andresoft.apirest.dto.CategoryDTO;
import com.co.andresoft.apirest.exception.CategoryNotFoundException;
import com.co.andresoft.apirest.model.dao.ICategoryRepository;
import com.co.andresoft.apirest.model.entity.Category;
import com.co.andresoft.apirest.model.service.ICategoryService;

@Service
public class CategoryServiceImpl implements ICategoryService {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private ICategoryRepository categoryRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<CategoryDTO> findAllCategories() {
		
		List<Category> categories = categoryRepository.findAll();
		
		return categories.stream().map(category -> mapEntityToDto(category))
				.collect(Collectors.toList());
	}
	
	@Override
	@Transactional(readOnly = true)
	public CategoryDTO getCategoryById(Long id) {
		
		Category category = categoryRepository.findById(id)
				.orElseThrow(() -> new CategoryNotFoundException("Category", "id", id));
		
		return mapEntityToDto(category);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Category findCategoryById(Long id) {
		Category category = categoryRepository.findCategoryById(id);
        if(category == null){
        	throw new CategoryNotFoundException("The category", "not found", id);
        }
        return category;
	}
	
	@Override
	@Transactional
	public CategoryDTO createCategory(CategoryDTO categoryDTO) {
		
		Category category = mapDtoToEntity(categoryDTO);
		
		Category newCategory = categoryRepository.save(category);
		
		CategoryDTO categoryResponse = mapEntityToDto(newCategory);
		
		return categoryResponse;
	}
	
	@Override
	@Transactional
	public CategoryDTO updateCategoryById(Long id, CategoryDTO categoryDTO) {
		Category category = findCategoryById(id);
		
		category.setName(categoryDTO.getName());
		
		Category updatedCategory = mapDtoToEntity(categoryDTO); 
		
		return mapEntityToDto(updatedCategory);
	}
	
	@Override
	@Transactional
	public void deleteCategoryById(Long id) {
		
		Category category = categoryRepository.findById(id)
				.orElseThrow(() -> new CategoryNotFoundException("Category", "id", id));
		
		categoryRepository.deleteById(category.getId());
		
	}
	
	private CategoryDTO mapEntityToDto(Category category) {
		CategoryDTO categoryDTO = modelMapper.map(category, CategoryDTO.class);
		return categoryDTO;
	}
	
	private Category mapDtoToEntity(CategoryDTO categoryDTO) {
		Category category = modelMapper.map(categoryDTO, Category.class);
		return category;
	}

}
