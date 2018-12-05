package com.perficient.cloud.products.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.stereotype.Service;

import com.perficient.cloud.products.model.Product;

@Service
public interface ProductsSearchService {

	/**
	 * Fetch Product string by Product ID
	 * 
	 * @param id - Product ID
	 * @return - Product Object
	 */
	public Product find(BigInteger id);

	/**
	 * Retrieve all Products with their product id's
	 * 
	 * @return Map of <Product ID, Product>
	 */
	public List<Product> retrieveAll();

	/**
	 * @param product
	 * @return
	 */
	public Product create(Product product);

}
