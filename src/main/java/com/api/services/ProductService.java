package com.api.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.api.entities.creates.CreateProduct;
import com.api.entities.gets.GetProduct;

public interface ProductService {
	public ArrayList<GetProduct> findProducts();
	public boolean createProduct(CreateProduct product);
	public boolean deleteProduct(String id);
}
