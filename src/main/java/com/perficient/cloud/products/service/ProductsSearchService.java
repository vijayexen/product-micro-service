package com.perficient.cloud.products.service;

import java.util.Map;

import org.springframework.stereotype.Service;

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
	 * Retrieve all Product String with their product id's
	 * 
	 * @return Map of <Product ID, Product String>
	 */
	public Map<Long, String> retrieveAll();

}
