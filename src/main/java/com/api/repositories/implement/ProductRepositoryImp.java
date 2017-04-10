package com.api.repositories.implement;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.api.entities.CreateProduct;
import com.api.model.Product;
import com.api.repositories.ProductRepository;

@Repository
public class ProductRepositoryImp implements ProductRepository{

	@Autowired
	private ProductRepository prRepo;
	
	@Override
	public ArrayList<Product> findProducts() {
		// TODO Auto-generated method stub
		return this.prRepo.findProducts();		
	}

	@Override
	public boolean createProduct(CreateProduct product) {
		return prRepo.createProduct(product);
	}
	
}
