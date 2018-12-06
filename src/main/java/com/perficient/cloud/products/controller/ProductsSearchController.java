package com.perficient.cloud.products.controller;

import java.math.BigInteger;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.perficient.cloud.products.model.Product;
import com.perficient.cloud.products.model.Error;
import com.perficient.cloud.products.service.ProductsSearchService;
import com.perficient.cloud.products.util.ProductsSearchUtils;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/products")
public class ProductsSearchController {

	private static final Logger log = LoggerFactory.getLogger(ProductsSearchController.class);

	@Autowired
	ProductsSearchService productSearchSrvc;

	@Autowired
	ProductsSearchUtils productsSearchUtils;

	@Autowired
	Gson gson;

	@RequestMapping(method = RequestMethod.GET, produces = "application/json", path = "/all")
	@ApiOperation(value = "Retrieve all Products from Database")
	@HystrixCommand(fallbackMethod = "defaultGetAllProducts")
	public String getAllProducts() {

		log.debug("getAllProducts");
		List<Product> products = productSearchSrvc.retrieveAll();
		return productsSearchUtils.toJson(products);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/search/{id}", produces = "application/json")
	@ApiOperation(value = "Retrieve a Product from DB based on its ID")
	@HystrixCommand(fallbackMethod = "defaultFindProductByID")
	public String findProductByID(@PathVariable("id") BigInteger id) {

		return productsSearchUtils.toJson(productSearchSrvc.find(id));
	}

	@RequestMapping(path = "/delete/{id}", produces = "application/json")
	@ApiOperation(value = "Remove document by Product id")
	@HystrixCommand(fallbackMethod = "defaultDeleteById")
	public String deleteById(@PathVariable("id") BigInteger id) {

		Product prod = productSearchSrvc.find(id);

		if (!productSearchSrvc.delete(id)) {
			Product p = new Product();
			p.setId(id);
			Error error = new Error("ERR1", "Product could not be found");
			p.setError(error);
			return productsSearchUtils.toJson(p);
		}

		return productsSearchUtils.toJson(prod);

	}

	@RequestMapping(path = "/delete", produces = "application/json", consumes = "application/json")
	@ApiOperation(value = "Remove document by Product request body")
	@HystrixCommand(fallbackMethod = "defaultDeleteByProduct")
	public String deleteByProduct(@RequestBody Product p) {

		if (!productSearchSrvc.delete(p.getId())) {
			Error error = new Error("ERR1", "Product could not be found");
			p.setError(error);
			return productsSearchUtils.toJson(p);
		}

		return productsSearchUtils.toJson(p);

	}

	@SuppressWarnings("unused")
	private String defaultGetAllProducts() {

		return productsSearchUtils.defaultErrorServiceInaccessible();
	}

	@SuppressWarnings("unused")
	private String defaultFindProductByID() {
		return productsSearchUtils.defaultErrorServiceInaccessible();
	}

	@SuppressWarnings("unused")
	private String defaultDeleteById() {
		return productsSearchUtils.defaultErrorServiceInaccessible();
	}

	@SuppressWarnings("unused")
	private String defaultDeleteByProduct() {
		return productsSearchUtils.defaultErrorServiceInaccessible();
	}

}
