package com.api.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.api.controller.file.storage.StorageService;
import com.api.entities.creates.CreateProduct;
import com.api.services.ProductService;


@RestController
@RequestMapping("/swapi")
public class ProductController {
		
	@Autowired private ProductService productService; 
	@Autowired private StorageService storageService;			
	@SuppressWarnings("rawtypes") private ArrayList list;
	private Map<String,Object> map;	
	private final String suffix = "/product";    // the suffix of uploading file
	
	/**
	 * Create product
	 * @param file
	 * @param name
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/product", method = RequestMethod.POST)
	public ResponseEntity<Map<String,Object>> createProduct(
			@RequestParam(value = "FILE", required=true) MultipartFile file, 
			@RequestParam(value = "NAME", required=true) String name) {
		map = new HashMap<String , Object>();
		CreateProduct p;		
		try{
			if (storageService.store(this.suffix, file)) {
				p = new CreateProduct();					
				p.setPr_name(name);
				p.setPr_image("images" + this.suffix + "/" + file.getOriginalFilename());
				list = new ArrayList<>();
				if (productService.createProduct(p)) {
					map.put("CODE", 200);
					map.put("MESSAGE","Success");					
					list.add(p);
					map.put("DATA", list);
				}else{					
					map.put("CODE", 403);
					map.put("MESSAGE","fail");
				}
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
				map.put("CODE", 200);					
				map.put("DATA", list);
				map.put("MESSAGE","No data");				
			}
		}catch(Exception e){
			e.printStackTrace();
			map.put("CODE", 500);
			map.put("MESSAGE", "Something is broken. Please contact to developers team!");			
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}

	@RequestMapping(value = "/product/{ID}", method = RequestMethod.DELETE)
	public ResponseEntity<Map<String,Object>> deleteProduct(
			@PathVariable("ID") String pr_id) {		
		map = new HashMap<String , Object>();					
		if (this.productService.deleteProduct(pr_id.trim())) {			
			map.put("CODE", 200);
			map.put("MESSAGE","Success");
			map.put("DATA", new ArrayList<>());			
		} else {	
			map.put("CODE", 500);
			map.put("MESSAGE","fail");
			map.put("DATA", new ArrayList<>());
			
		}	
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
}
