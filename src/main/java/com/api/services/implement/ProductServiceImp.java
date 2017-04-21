package com.api.services.implement;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.entities.creates.CreateProduct;
import com.api.entities.gets.GetProduct;
import com.api.repositories.ProductRepository;
import com.api.services.ProductService;

@Service
public class ProductServiceImp implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public ArrayList<GetProduct> findProducts() {
		return productRepository.findProducts();
	}

	@Override
	public boolean createProduct(CreateProduct product) {		
		return productRepository.createProduct(product);
	}

	@Override
	public boolean deleteProduct(String id) {		
		return productRepository.deleteProduct(id);
	}

}
