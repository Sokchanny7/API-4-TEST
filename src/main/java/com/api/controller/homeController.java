package com.api.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class homeController {
			
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String Home(ModelMap model){		
		return "home";
	}
}