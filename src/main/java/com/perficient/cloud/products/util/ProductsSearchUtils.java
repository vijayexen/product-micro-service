package com.perficient.cloud.products.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

@Component
public class ProductsSearchUtils {

	@Autowired
	Gson gson;

	public String toJson(Object o) {

		return gson.toJson(o);
	}

}
