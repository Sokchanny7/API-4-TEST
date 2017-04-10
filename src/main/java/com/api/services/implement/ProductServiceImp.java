package com.api.services.implement;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.entities.CreateProduct;
import com.api.model.Product;
import com.api.repositories.ProductRepository;
import com.api.services.ProductService;

@Service
public class ProductServiceImp implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public ArrayList<Product> findProducts() {
		return productRepository.findProducts();
	}

	@Override
	public boolean createProduct(CreateProduct product) {		
		return productRepository.createProduct(product);
	}

}
