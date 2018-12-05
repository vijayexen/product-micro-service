package com.perficient.cloud.products.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.google.gson.Gson;
import com.perficient.cloud.products.dao.ProductsSearchDao;
import com.perficient.cloud.products.dao.impl.ProductsSearchDaoImpl;
import com.perficient.cloud.products.service.ProductsSearchService;
import com.perficient.cloud.products.service.impl.ProductsSearchServiceImpl;

@Configuration
@EnableAutoConfiguration
@ComponentScan({ "com.perficient.cloud.products" })
public class SpringConfig {

	@Bean
	public ProductsSearchService productsSearchService() {
		return new ProductsSearchServiceImpl();
	}

	@Bean
	public ProductsSearchDao productSearchDaoBean() {
		return new ProductsSearchDaoImpl();
	}

	@Bean
	public Gson gson() {
		return new Gson();
	}

}
