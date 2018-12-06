package com.perficient.cloud.products.service.impl;

import java.math.BigInteger;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.perficient.cloud.products.dao.ProductsSearchDao;
import com.perficient.cloud.products.model.Error;
import com.perficient.cloud.products.model.Product;
import com.perficient.cloud.products.service.ProductsSearchService;

public class ProductsSearchServiceImpl implements ProductsSearchService {

	private static final Logger log = LoggerFactory.getLogger(ProductsSearchServiceImpl.class);

	@Autowired
	ProductsSearchDao productSearchDao;

	@Override
	public Product find(BigInteger id) {

		Error e;
		log.info("findProductByID: ID: {}", String.valueOf(id));
		Product p = productSearchDao.findProductById(id);
		if (null == p) {
			e = new Error("ERR1", "Product not found");
			p = new Product();
			p.setId(id);
			p.setError(e);
		}

		log.info("findProductById: Returning Product {} for ID: {}", p.getName(), id);
		return p;
	}

	@Override
	public List<Product> retrieveAll() {

		List<Product> products = productSearchDao.findAllProducts();
		return products;
	}

	@Override
	public Product create(Product product) {
		productSearchDao.insert(product);
		return product;
	}

	@Override
	public Boolean delete(Product p) {

		return productSearchDao.deleteProduct(p);
	}

	@Override
	public Boolean delete(BigInteger id) {
		return productSearchDao.deleteById(id);
	}

}
