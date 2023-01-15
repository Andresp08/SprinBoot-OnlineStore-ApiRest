package com.co.andresoft.apirest.dto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


public class ProductDTO {

	private Long id;
	
	@NotEmpty
	@NotBlank
	@Size(min = 2)
	private String name;
	
	private Double price;
	
	@NotEmpty
	@NotBlank
	@Size(min = 10)
	private String description;
	
	private Long categoryId;
	
	public ProductDTO() {}

	public ProductDTO(Long id, String name, Double price,String description, Long categoryId) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.categoryId = categoryId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	
}
