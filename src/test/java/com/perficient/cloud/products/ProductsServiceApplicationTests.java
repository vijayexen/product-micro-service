package com.perficient.cloud.products;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.test.context.junit4.SpringRunner;

import com.perficient.cloud.products.dao.ProductsSearchDao;
import com.perficient.cloud.products.model.Price;
import com.perficient.cloud.products.model.Product;
import com.perficient.cloud.products.service.ProductsSearchService;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableMongoRepositories(basePackageClasses = ProductsSearchDao.class)
public class ProductsServiceApplicationTests {

	@Autowired
	ProductsSearchService productSearchSrv;

	@Test
	public void testFindProductById() {
		Product actual = productSearchSrv.find("28481675540731914413735584123");
		Assert.assertEquals("STORM", actual.getName());
	}

	@Test
	public void testFindAllProducts() {

		Assert.assertTrue(productSearchSrv.retrieveAll().size() > 0);
	}

	@Test
	public void saveObject() {
		Product p = new Product();
		p.setId(String.valueOf("28481675540731914413735584123"));
		p.setBandwidth("100MB");
		p.setBuildingExtn("100200");
		p.setName("STORM");
		p.setRouter("NETGEAR");
		p.setTransport("NTP");
		Price price = new Price();
		price.setBasePrice(BigDecimal.valueOf(20));
		price.setDiscount(BigDecimal.valueOf(0));
		price.setShippingCharge(BigDecimal.valueOf(2));
		p.setPrice(price);

		Product pInserted = productSearchSrv.create(p);
		Product pActual = productSearchSrv.find(pInserted.getId());

		Assert.assertEquals(p.getName(), pActual.getName());

	}

}
