package com.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/swapi/post")
public class PostController {

	@GetMapping("/posts")
	public void getPosts(){
		
	}
	
}
