package com.co.andresoft.apirest.model.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.co.andresoft.apirest.dto.ProductDTO;

import com.co.andresoft.apirest.model.dao.IProductRepository;
import com.co.andresoft.apirest.model.entity.Category;
import com.co.andresoft.apirest.model.entity.Product;
import com.co.andresoft.apirest.model.service.ICategoryService;
import com.co.andresoft.apirest.model.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService {

	
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private IProductRepository productRepository;

	@Autowired
	private ICategoryService categoryService;
	
	@Override
	@Transactional
	public ProductDTO createProduct(ProductDTO productDTO) {

		Product product = mapDtoToEntity(productDTO);

		Category category = categoryService.findCategoryById(productDTO.getCategoryId());

		product.setCategory(category);

		Product newProduct = productRepository.save(product);

		return mapEntityToDto(newProduct);
	}
	
	private ProductDTO mapEntityToDto(Product product) {
		ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);
		return productDTO;
	}

	private Product mapDtoToEntity(ProductDTO productDTO) {
		Product product = modelMapper.map(productDTO, Product.class);
		return product;
	}

}
