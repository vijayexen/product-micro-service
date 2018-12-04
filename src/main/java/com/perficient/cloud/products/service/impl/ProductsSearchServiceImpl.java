package com.perficient.cloud.products.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.perficient.cloud.products.dao.ProductsSearchDao;
import com.perficient.cloud.products.service.ProductsSearchService;

public class ProductsSearchServiceImpl implements ProductsSearchService {

	@Autowired
	ProductsSearchDao productSearchDao;

	@Override
	public String find(Long id) {
		return productSearchDao.findProductById(id);
	}

	@Override
	public Map<Long, String> retrieveAll() {
		return productSearchDao.findAllProducts();
	}

}
