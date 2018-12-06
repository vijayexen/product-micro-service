package com.perficient.cloud.products.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.perficient.cloud.products.model.Product;

@Repository
public interface ProductsSearchDao {

	public List<Product> findAllProducts();

	public Product findProductById(String Id);

	public Product insert(Product p);

	public Boolean deleteProduct(Product product);

	public Boolean deleteById(String id);

}
