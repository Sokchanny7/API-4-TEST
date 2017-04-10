package com.api.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.api.entities.CreateProduct;
import com.api.model.Product;

public interface ProductService {
	public ArrayList<Product> findProducts();
	public boolean createProduct(CreateProduct product);
}
