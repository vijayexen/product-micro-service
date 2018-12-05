package com.perficient.cloud.products.controller;

import java.math.BigInteger;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.perficient.cloud.products.model.Product;
import com.perficient.cloud.products.service.ProductsSearchService;

@RestController
@RequestMapping(path = "/products")
public class ProductsSearchController {

	private static final Logger log = LoggerFactory.getLogger(ProductsSearchController.class);

	@Autowired
	ProductsSearchService productSearchSrvc;

	@Autowired
	Gson gson;

	@RequestMapping(method = RequestMethod.GET, produces = "application/json", path = "/all")
	public String getAllProducts() {
		
		log.debug("getAllProducts");
		List<Product> products = productSearchSrvc.retrieveAll();
		String productsArr = gson.toJson(products);
		return productsArr;
	}

	@RequestMapping(method = RequestMethod.GET, path = "/search/{id}", produces = "application/json")
	public String findProductByID(@PathVariable("id") BigInteger id) {
		
		return gson.toJson(productSearchSrvc.find(id));
	}
}
