package com.co.andresoft.apirest.model.service;

import com.co.andresoft.apirest.dto.ProductDTO;
import com.co.andresoft.apirest.dto.ProductResponse;

public interface IProductService {

	public ProductResponse getAllProducts(int numberPage, int totalRegisters, String sortBy, 
			String sortDir);
	
	public ProductDTO getProductById(Long id);
	
	public ProductDTO createProduct(ProductDTO productDTO);
	
	public ProductDTO updateProductById(Long id, ProductDTO productDTO);

	public void deleteProductById(Long id);
	
}
