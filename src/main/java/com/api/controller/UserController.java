package com.api.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.api.controller.file.storage.StorageService;
import com.api.entities.creates.CreateProduct;
import com.api.entities.creates.CreateUser;
import com.api.entities.gets.GetUser;
import com.api.services.UserService;
import com.wordnik.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/swapi/user")
public class UserController {
	
	private Map<String,Object>map;
	@SuppressWarnings("rawtypes")
	private List list;	
	@Autowired UserService userService;
	@Autowired StorageService storageService;
	private final String suffix = "/user";    // the suffix of uploading file
	
	
	@GetMapping("/users")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Map<String,Object>> findProducts() {
		map 	= new HashMap<String , Object>();
		list 	= this.userService.getUsers();
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
	
	
	@RequestMapping(method = RequestMethod.POST) //, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	//@ApiOperation(notes = "Files a complaint on a translationData", value = "fileComplaint")
	public ResponseEntity<Map<String,Object>> createProduct(
			@RequestBody CreateUser createUser
			//,@RequestPart (value = "FILE", required=true) MultipartFile file
			){ 
			//@RequestParam(value = "NAME", required=true) String name,
			//@RequestParam(value = "EMAIL", required=true) String email,
			//@RequestParam(value = "PASSWORED", required=true) String password) {
		map = new HashMap<String , Object>();
		//CreateUser createUser;		
		try{
			//if (storageService.store(this.suffix, file)) {								
				//String image = "images/" + this.suffix + "/" + file.getOriginalFilename();
				//createUser = new CreateUser(name, image, email, password);					
				list = new ArrayList<>();
				if (userService.createUser(createUser)) {
					map.put("CODE", 200);
					map.put("MESSAGE","Success");					
					list.add(createUser);
					map.put("DATA", list);
				}else{					
					map.put("CODE", 403);
					map.put("MESSAGE","fail");
				}
			//}
		}catch(Exception e){
			map.put("CODE", 500);
			map.put("MESSAGE", "Something is broken. Please contact to developers team!\n\n" + e.getMessage());
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/abc", method = RequestMethod.POST, consumes = {"multipart/form-data"})
	public String printWelcome(@RequestParam (value = "FILE", required=true) MultipartFile name, @RequestBody CreateUser user) {	    	    
	    return "hello";
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.POST, consumes = {"multipart/form-data", "multipart/mixed"})
	@ResponseBody
	public String executeSampleService(
				@RequestPart CreateUser user,
				@RequestPart @Valid  MultipartFile file) {
	   return "Hello " + user.getU_name();
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<Map<String,Object>> deleteUser(
			@PathVariable("ID") String u_id) {		
		map = new HashMap<String , Object>();					
		if (this.userService.deteleUser(u_id.trim())) {			
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












