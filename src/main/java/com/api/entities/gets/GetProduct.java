package com.api.entities.gets;

import com.api.entities.creates.CreateProduct;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GetProduct extends CreateProduct {
	
	@JsonProperty("ID")
	private String pr_id;
	
	public String getPr_id() {
		return pr_id;
	}

	public void setPr_id(String pr_id) {
		this.pr_id = pr_id;
	}

	public GetProduct(String pr_id, String pr_name, String pr_image) {
		super();
		this.pr_id = pr_id;
		this.pr_name = pr_name;
		this.pr_image = pr_image;
	}
	
}
