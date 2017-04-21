package com.api.repositories;

import java.util.ArrayList;


import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.api.entities.creates.CreateProduct;
import com.api.entities.gets.GetProduct;
@Repository
public interface ProductRepository {	
	public ArrayList<GetProduct> findProducts();			
	public boolean createProduct(CreateProduct product);				
	public boolean deleteProduct(String id);
}
