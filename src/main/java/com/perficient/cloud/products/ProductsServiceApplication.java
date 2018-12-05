package com.perficient.cloud.products;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.perficient.cloud.products.dao.ProductsSearchDao;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = ProductsSearchDao.class)
public class ProductsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductsServiceApplication.class, args);
	}

}
