package com.perficient.cloud.products.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.perficient.cloud.products.dao.ProductsSearchDao;

public class ProductsSearchDaoImpl implements ProductsSearchDao {

	private static final Logger log = LoggerFactory.getLogger(ProductsSearchDaoImpl.class);

	private Map<Long, String> productMap;

	public ProductsSearchDaoImpl() {
		this.productMap = new HashMap<>();
		this.productMap.put(100L, "STORM");
		this.productMap.put(101L, "FAST");
		this.productMap.put(102L, "GENERIC");
		this.productMap.put(103L, "STORM SPEED");
		this.productMap.put(104L, "ECONOMY SPEED");
	}

	@Override
	public Map<Long, String> findAllProducts() {
		return this.productMap;
	}

	@Override
	public String findProductById(Long Id) {
		log.debug("findProductById: ID: {}", Id);
		String productStr = this.productMap.get(Id);
		log.info("findProductById: Retruning Product string {} for ID: {}", productStr, Id);
		return productStr;
	}

}
