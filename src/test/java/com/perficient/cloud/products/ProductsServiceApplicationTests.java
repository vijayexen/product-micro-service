package com.perficient.cloud.products;

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.perficient.cloud.products.model.Product;
import com.perficient.cloud.products.service.ProductsSearchService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductsServiceApplicationTests {

	@Autowired
	ProductsSearchService productSearchSrv;

	@Test
	public void testFindProductById() {
		String actual = productSearchSrv.find(100L);
		Assert.assertEquals("STORM", actual);

	}

	@Test
	public void testFindAllProducts() {
		Map<Long, Product> productsMap = null;//productSearchSrv.retrieveAll();
		Assert.assertFalse(productsMap.isEmpty());
	}

}
