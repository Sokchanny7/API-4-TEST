package com.api.controller.file.storage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@ConfigurationProperties("storage")
@PropertySource(value={"classpath:configuration.properties"})
public class StorageProperties {
	
	@Autowired
	private Environment environment;   

    public String getLocation() {
        return environment.getProperty("MOL.dataSource.upload-dir");
    }
    
}
