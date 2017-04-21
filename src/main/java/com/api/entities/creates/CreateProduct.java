package com.api.entities.creates;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateProduct {	
	
	@JsonProperty("NAME")
	protected String pr_name;
	
	@JsonProperty("IMAGE")		
	protected String pr_image;
	
	public String getPr_name() {
		return pr_name;
	}
	public void setPr_name(String pr_name) {
		this.pr_name = pr_name;
	}
	public String getPr_image() {
		return pr_image;
	}
	public void setPr_image(String pr_image) {
		this.pr_image = pr_image;
	}
	
}
