package com.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {
	
	@JsonProperty("ID")
	private String pr_id;
	
	@JsonProperty("NAME")
	private String pr_name;
	
	public Product() {
		super();		
	}

	public String getPr_id() {
		return pr_id;
	}

	public void setPr_id(String pr_id) {
		this.pr_id = pr_id;
	}

	public String getPr_name() {
		return pr_name;
	}

	public void setPr_name(String pr_name) {
		this.pr_name = pr_name;
	}

	public Product(String pr_id, String pr_name) {
		super();
		this.pr_id = pr_id;
		this.pr_name = pr_name;
	}
	
}
