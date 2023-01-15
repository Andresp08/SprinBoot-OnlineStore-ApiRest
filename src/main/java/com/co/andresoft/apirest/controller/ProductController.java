package com.co.andresoft.apirest.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.andresoft.apirest.dto.ProductDTO;
import com.co.andresoft.apirest.model.service.IProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private IProductService productService;
	
	@PostMapping(path = "/new-product", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> addProduct(@Valid @RequestBody ProductDTO productDTO) {
		
		Map<String, Object> jsonResponseMap = new LinkedHashMap<String, Object>();
		
		productService.createProduct(productDTO);
		
		jsonResponseMap.put("status", "Ok");
		jsonResponseMap.put("message", "Product created succesfully!");
		return new ResponseEntity<>(jsonResponseMap, HttpStatus.CREATED);
	}
	
}
