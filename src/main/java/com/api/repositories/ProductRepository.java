package com.api.repositories;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.api.entities.CreateProduct;
import com.api.model.Product;
@Repository
public interface ProductRepository {
	final String RS_PRODUCT = "Select * from tb_product";
	@Select(RS_PRODUCT)
	public ArrayList<Product> findProducts();
	
	final String INSERT="INSERT INTO tb_product (pr_name) VALUES (#{pr_name})";
	@Insert(INSERT)
	public boolean createProduct(CreateProduct product);
}
