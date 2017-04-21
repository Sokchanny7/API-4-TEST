package com.api.controller.file.storage;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import com.api.entities.UploadFile;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.stream.Stream;

public interface StorageService {
    void init();
    
    boolean store(String suffix,MultipartFile file);
    
    ArrayList<UploadFile> loadAll(String suffix);
    
    Path load(String suffix, String filename);
    
    Resource loadAsResource(String suffix, String filename);
    
    void deleteAll(String suffix);
}
