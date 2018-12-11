package com.perficient.cloud.products.service;

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
	public Product find(String id);

	/**
	 * Fetch Product string by Product name
	 * 
	 * @param id - Product name
	 * @return - Product Object
	 */
	public Product findByName(String name);

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

	/**
	 * @param p
	 * @return
	 */
	public Boolean delete(Product p);

	/**
	 * @param id
	 * @return
	 */
	public Boolean delete(String id);

	/**
	 * @return
	 */
	public List<String> retrieveProductNames();

}
