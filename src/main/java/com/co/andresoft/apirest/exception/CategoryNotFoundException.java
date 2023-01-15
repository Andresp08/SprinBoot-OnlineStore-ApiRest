package com.co.andresoft.apirest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CategoryNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	private String categoryName;
	private String categoryField;
	private Long fieldValue;
	
	public CategoryNotFoundException(String categoryName, String categoryField, Long fieldValue) {
		super(String.format("%s not available with: %s : '%s'", categoryName, categoryField, fieldValue));
		this.categoryName = categoryName;
		this.categoryField = categoryField;
		this.fieldValue = fieldValue;
	}
	
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryField() {
		return categoryField;
	}
	public void setCategoryField(String categoryField) {
		this.categoryField = categoryField;
	}
	public Long getFieldValue() {
		return fieldValue;
	}
	public void setFieldValue(Long fieldValue) {
		this.fieldValue = fieldValue;
	}
}
