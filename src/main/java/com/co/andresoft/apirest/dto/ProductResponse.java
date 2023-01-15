package com.co.andresoft.apirest.dto;

import java.util.List;

public class ProductResponse {

	private List<ProductDTO> products;

	private int pageNumber;

	private int totalRegisters;

	private Long totalElements;

	private int totalPages;

	private boolean isLastPage;

	public List<ProductDTO> getProducts() {
		return products;
	}

	public void setProducts(List<ProductDTO> products) {
		this.products = products;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getTotalRegisters() {
		return totalRegisters;
	}

	public void setTotalRegisters(int totalRegisters) {
		this.totalRegisters = totalRegisters;
	}

	public Long getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(Long totalElements) {
		this.totalElements = totalElements;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public boolean isLastPage() {
		return isLastPage;
	}

	public void setLastPage(boolean isLastPage) {
		this.isLastPage = isLastPage;
	}
}
