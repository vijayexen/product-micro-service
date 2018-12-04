package com.perficient.cloud.products.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public interface ProductsSearchDao {

	public Map<Long, String> findAllProducts();

	public String findProductById(Long Id);

}
