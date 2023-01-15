package com.co.andresoft.apirest.model.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.co.andresoft.apirest.dto.ProductDTO;
import com.co.andresoft.apirest.dto.ProductResponse;
import com.co.andresoft.apirest.exception.ProductNotFoundException;
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
	@Transactional(readOnly = true)
	public ProductResponse getAllProducts(int numberPage, int totalRegisters, String sortBy, String sortDir) {

		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
				: Sort.by(sortBy).descending();

		Pageable pageable = PageRequest.of(numberPage, totalRegisters, sort);

		Page<Product> products = productRepository.findAll(pageable);

		List<Product> listProducts = products.getContent();

		List<ProductDTO> content = listProducts.stream().map(product -> mapEntityToDto(product))
				.collect(Collectors.toList());

		ProductResponse productResponse = new ProductResponse();
		productResponse.setProducts(content);
		productResponse.setPageNumber(products.getNumber());
		productResponse.setTotalRegisters(products.getSize());
		productResponse.setTotalElements(products.getTotalElements());
		productResponse.setTotalPages(products.getTotalPages());
		productResponse.setLastPage(products.isLast());

		return productResponse;
	}

	@Override
	@Transactional(readOnly = true)
	public ProductDTO getProductById(Long id) {

		Product product = productRepository.findById(id)
				.orElseThrow(() -> new ProductNotFoundException("Product", "id", id));

		return mapEntityToDto(product);
	}
	
	@Override
	@Transactional
	public ProductDTO createProduct(ProductDTO productDTO) {

		Product product = mapDtoToEntity(productDTO);

		Category category = categoryService.findCategoryById(productDTO.getCategory_id());

		product.setCategory(category);

		Product newProduct = productRepository.save(product);

		return mapEntityToDto(newProduct);
	}
	
	@Override
	@Transactional
	public ProductDTO updateProductById(Long id, ProductDTO productDTO) {
		
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new ProductNotFoundException("Product", "id", id));
		
		product.setDescription(productDTO.getDescription());
		product.setName(productDTO.getName());
		product.setPrice(productDTO.getPrice());
		product.setCategory_id(productDTO.getCategory_id());
		
		Product updatedProduct = mapDtoToEntity(productDTO); 
		
		return mapEntityToDto(updatedProduct);
	}
	
	@Override
	@Transactional
	public void deleteProductById(Long id) {
		
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new ProductNotFoundException("Product", "id", id));
		
		productRepository.deleteById(product.getId());
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
