package com.co.andresoft.apirest.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.co.andresoft.apirest.model.entity.Category;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long>{

	@Query("SELECT c FROM Category c WHERE c.id=?1")
	public Category findCategoryById(Long id);
	
}
