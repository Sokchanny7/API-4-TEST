package com.api.entities.gets;

import com.api.entities.creates.CreateUser;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GetUser extends CreateUser {	
	@JsonProperty("ID")
	private String 	u_id;

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	
}
