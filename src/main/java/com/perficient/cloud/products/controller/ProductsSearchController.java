package com.perficient.cloud.products.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.perficient.cloud.products.service.ProductsSearchService;

@RestController
@RequestMapping(path = "/products")
public class ProductsSearchController {

	private static final Logger log = LoggerFactory.getLogger(ProductsSearchController.class);

	@Autowired
	ProductsSearchService productSearchSrvc;

	@RequestMapping(method = RequestMethod.GET, produces = "application/json", path = "/all")
	public String getAllProducts() {
		log.debug("getAllProducts");
		productSearchSrvc.retrieveAll();
		return null;
	}
}
