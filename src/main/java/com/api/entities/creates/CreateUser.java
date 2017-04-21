package com.api.entities.creates;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateUser{	
		
	@JsonProperty("NAME") protected String 	u_name;
	
	@JsonProperty("IMAGE") protected String 	u_image;
	
	@JsonProperty("EMAIL") protected String 	u_email;
	
	@JsonProperty("PASSWORD") protected String u_password;

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public String getU_image() {
		return u_image;
	}

	public void setU_image(String u_image) {
		this.u_image = u_image;
	}

	public String getU_email() {
		return u_email;
	}

	public void setU_email(String u_email) {
		this.u_email = u_email;
	}

	public String getU_password() {
		return u_password;
	}

	public void setU_password(String u_password) {
		this.u_password = u_password;
	}	
	
}
