package com.co.andresoft.apirest.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.co.andresoft.apirest.dto.ProductDTO;
import com.co.andresoft.apirest.dto.ProductResponse;
import com.co.andresoft.apirest.model.service.IProductService;
import com.co.andresoft.apirest.util.AppConstants;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private IProductService productService;

	@GetMapping(path = "/get-products", produces = "application/json")
	public ProductResponse getProducts(
			@RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_NUMBER_PAGE, 
			required = false) int numberPage,
		@RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_NUMBER_REGISTERS, 
			required = false) int totalRegisters,
		@RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT, 
			required = false) String sortBy,
		@RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, 
			required = false) String sortDir){
		
		return productService.getAllProducts(numberPage, totalRegisters, sortBy, sortDir);
	}
	
	@GetMapping(path = "/get-product/{id}", produces = "application/json")
	public ResponseEntity<ProductDTO> getOneProductById(@PathVariable(name = "id") Long id){
		return ResponseEntity.ok(productService.getProductById(id));
	}

	@PostMapping(path = "/new-product", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> addProduct(@Valid @RequestBody ProductDTO productDTO) {

		Map<String, Object> jsonResponseMap = new LinkedHashMap<String, Object>();

		productService.createProduct(productDTO);

		jsonResponseMap.put("status", "Ok");
		jsonResponseMap.put("message", "Product created succesfully!");
		return new ResponseEntity<>(jsonResponseMap, HttpStatus.CREATED);
	}
	
	@PutMapping(path = "/update-product/{id}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> updateProductById(
			@PathVariable(name = "id") Long id,
			@Valid @RequestBody ProductDTO productDTO){
		
		Map<String, Object> jsonResponseMap = new LinkedHashMap<String, Object>();
		
		productService.updateProductById(id, productDTO);
		
		jsonResponseMap.put("status", "Ok");
		jsonResponseMap.put("message", "Product created succesfully!");
		
		return new ResponseEntity<>(jsonResponseMap, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete-product/{id}")
	public ResponseEntity<Object> DeleteProductById(@PathVariable(name = "id") Long id){
		
		Map<String, Object> jsonResponseMap = new LinkedHashMap<String, Object>();
		
		productService.deleteProductById(id);
		
		jsonResponseMap.put("status", "Ok");
		jsonResponseMap.put("message", "Product deleted succesfully!");
		
		return new ResponseEntity<>(jsonResponseMap, HttpStatus.OK);
	}
	

}
