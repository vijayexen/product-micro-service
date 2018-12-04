package com.perficient.cloud.products.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.perficient.cloud.products.dao.ProductsSearchDao;
import com.perficient.cloud.products.dao.impl.ProductsSearchDaoImpl;
import com.perficient.cloud.products.service.ProductsSearchService;
import com.perficient.cloud.products.service.impl.ProductsSearchServiceImpl;

@Configuration
@ComponentScan({ "com.perficient.cloud.products" })
public class SpringConfigTest {

	@Bean
	public ProductsSearchDao productSearchDaoBean() {
		return new ProductsSearchDaoImpl();
	}

	@Bean
	public ProductsSearchService productsSearchServiceBean() {
		return new ProductsSearchServiceImpl();
	}

}
