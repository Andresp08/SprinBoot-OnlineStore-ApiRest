package com.co.andresoft.apirest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String productName;
	private String productField;
	private Long fieldValue;

	public ProductNotFoundException(String productName, String productField, Long fieldValue) {
		super(String.format("%s not available with: %s : '%s'", productName, productField, fieldValue));
		this.productName = productName;
		this.productField = productField;
		this.fieldValue = fieldValue;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductField() {
		return productField;
	}

	public void setProductField(String productField) {
		this.productField = productField;
	}

	public Long getFieldValue() {
		return fieldValue;
	}

	public void setFieldValue(Long fieldValue) {
		this.fieldValue = fieldValue;
	}
}
