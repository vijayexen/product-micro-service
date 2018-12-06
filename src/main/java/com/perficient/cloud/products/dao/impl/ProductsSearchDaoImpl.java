package com.perficient.cloud.products.dao.impl;

import java.math.BigInteger;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.client.result.DeleteResult;
import com.perficient.cloud.products.dao.ProductsSearchDao;
import com.perficient.cloud.products.model.Product;

public class ProductsSearchDaoImpl implements ProductsSearchDao {

	private static final Logger log = LoggerFactory.getLogger(ProductsSearchDaoImpl.class);

	@Autowired
	MongoOperations mongoOperations;

	@Override
	public List<Product> findAllProducts() {

		Query q = new Query();
		q.addCriteria(Criteria.byExample(Product.class));

		List<Product> products = this.mongoOperations.findAll(Product.class);

		return products;
	}

	@Override
	public Product findProductById(BigInteger Id) {
		log.debug("findProductById: ID: {}", Id);

		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(Id));

		log.debug(query.toString());
		Product product = this.mongoOperations.findOne(query, Product.class);

		return product;
	}

	@Override
	public Product insert(Product p) {

		if (null != p) {
			mongoOperations.save(p);
		}
		return p;
	}

	@Override
	public Boolean deleteProduct(Product product) {

		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(product.getId()));

		DeleteResult deletedResult = mongoOperations.remove(query, Product.class);

		if (deletedResult.getDeletedCount() > 0) {
			return Boolean.TRUE;
		}

		return Boolean.FALSE;
	}

	@Override
	public Boolean deleteById(BigInteger id) {

		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(id));

		DeleteResult deletedResult = mongoOperations.remove(query, Product.class);

		if (deletedResult.getDeletedCount() > 0) {
			return Boolean.TRUE;
		}

		return Boolean.FALSE;
	}

}
