package com.co.andresoft.apirest.dto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


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
	
	private Long category_id;
	
	public ProductDTO() {}
	
	@JsonCreator
    public ProductDTO(@JsonProperty("id") Long id,
                      @JsonProperty("name") String name,
                      @JsonProperty("price") Double price,
                      @JsonProperty("description") String description,
                      @JsonProperty("categoryId") Long category_id){
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.category_id = category_id;
    }

	/*public ProductDTO(Long id, String name, Double price,String description, Long categoryId) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.categoryId = categoryId;
	}*/

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

	public Long getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Long category_id) {
		this.category_id = category_id;
	}
	
}
