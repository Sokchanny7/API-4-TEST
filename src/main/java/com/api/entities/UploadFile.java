package com.api.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UploadFile {
	
	@JsonProperty("NAME")
	private String name;
	@JsonProperty("PATH")
	private String path;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
}
