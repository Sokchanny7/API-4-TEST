package com.api.controller.product;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.api.entities.CreateProduct;
import com.api.model.Product;
import com.api.services.ProductService;


@RestController
@RequestMapping("/swapi")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	private Map<String,Object>map;
	@SuppressWarnings("rawtypes")
	private ArrayList list;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/product", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<Map<String,Object>> createProduct(@RequestBody CreateProduct product) {
		map = new HashMap<String , Object>();
			if(product != null){				
				list.add(product);
			}
		try{
			if (productService.createProduct(product)) {
				map.put("CODE", 200);
				map.put("MESSAGE","Success");
				map.put("DATA", new ArrayList<>());
			}else{
				map.put("CODE", 201);
				map.put("MESSAGE","fail");
			}
		}catch(Exception e){
			map.put("CODE", 500);
			map.put("MESSAGE", "Something is broken. Please contact to developers team!");
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ResponseEntity<Map<String,Object>> findProducts() {
		map 	= new HashMap<String , Object>();
		list 	= productService.findProducts();
		try{
			if(!list.isEmpty()){
				map.put("CODE", 200);
				map.put("MESSAGE","Success");
				map.put("DATA", list);
			}else{
				map.put("CODE", 201);
				map.put("MESSAGE","fail");
			}
		}catch(Exception e){
			map.put("CODE", 500);
			map.put("MESSAGE", "Something is broken. Please contact to developers team!");
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}

	
}
