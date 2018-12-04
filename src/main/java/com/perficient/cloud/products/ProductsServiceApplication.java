package com.perficient.cloud.products;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.perficient.cloud.products.dao.ProductsSearchDao;
import com.perficient.cloud.products.dao.impl.ProductsSearchDaoImpl;
import com.perficient.cloud.products.service.ProductsSearchService;
import com.perficient.cloud.products.service.impl.ProductsSearchServiceImpl;

@SpringBootApplication
@ComponentScan({ "com.perficient.cloud.products" })
public class ProductsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductsServiceApplication.class, args);
	}

	@Bean
	public ProductsSearchDao productsSearchDao() {
		return new ProductsSearchDaoImpl();
	}

	@Bean
	public ProductsSearchService productsSearchService() {
		return new ProductsSearchServiceImpl();
	}
}
