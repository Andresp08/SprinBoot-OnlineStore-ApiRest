package com.co.andresoft.apirest.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.co.andresoft.apirest.model.entity.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long>{

}
