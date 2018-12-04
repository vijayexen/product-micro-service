package com.perficient.cloud.products.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.perficient.cloud.products.model.Product;

@Service
public interface ProductsSearchService {

	/**
	 * Fetch Product string by Product ID
	 * 
	 * @param id
	 *            - Product ID
	 * @return - Product String
	 */
	public String find(Long id);

	/**
	 * Retrieve all Products with their product id's
	 * 
	 * @return Map of <Product ID, Product>
	 */
	public Map<Long, Product> retrieveAll();

}
