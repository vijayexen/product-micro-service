package com.perficient.cloud.products.dao.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.perficient.cloud.products.dao.ProductsSearchDao;
import com.perficient.cloud.products.model.Product;

public class ProductsSearchDaoImpl implements ProductsSearchDao {

	private static final Logger log = LoggerFactory.getLogger(ProductsSearchDaoImpl.class);

	public ProductsSearchDaoImpl() {
	}

	@Override
	public Map<Long, Product> findAllProducts() {
		return null;
	}

	@Override
	public String findProductById(Long Id) {
		log.debug("findProductById: ID: {}", Id);
		String productStr = null;
		log.info("findProductById: Returning Product string {} for ID: {}", productStr, Id);
		return productStr;
	}

}
