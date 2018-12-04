package com.perficient.cloud.products.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.perficient.cloud.products.model.Product;

@Repository
public interface ProductsSearchDao {

	public Map<Long, Product> findAllProducts();

	public String findProductById(Long Id);

}
