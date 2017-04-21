package com.api.controller.file.storage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import com.api.entities.UploadFile;
import com.arjuna.ats.internal.jdbc.drivers.modifiers.extensions;
import com.google.common.base.Function;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Locale.LanguageRange;
import java.util.stream.Stream;

@Service
public class FileSystemStorageService implements StorageService {

    private Path rootLocation;
    private String upload_dir;
    
    private StorageProperties properties;
    
    @Autowired
    public FileSystemStorageService(StorageProperties properties) {
    	this.properties = properties;
    	this.configurePath(properties.getLocation());                
    }

    /**
     * Upload file
     */
    @Override
    public boolean store(String suffix, MultipartFile file) {
    	this.configurePath(suffix);    	    	    
        try {
        	if (!(Files.exists(this.rootLocation))) {
        		try {        	
                    Files.createDirectory(this.rootLocation);
                } catch (IOException e) {
                    throw new StorageException("Could not initialize storage", e);
                }
        	} 
        	if (file.isEmpty()) {            	
                throw new StorageException("Failed to store empty file " + file.getOriginalFilename());                
            }
            Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()));
            return true;
        } catch (IOException e) {
            throw new StorageException("Failed to store file " + file.getOriginalFilename(), e);            
        }        
    }
    
    /***
     * to find all file in specific directory 
     * @param folder
     * @return
     */
    public ArrayList<UploadFile> listFiles(final File folder) {  
        ArrayList<UploadFile> fs = new ArrayList<UploadFile>();
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                fs.addAll(listFiles(fileEntry));
            } else {                
                UploadFile uf = new UploadFile();
                uf.setPath(fileEntry.getPath());
                uf.setName(fileEntry.getName());
                fs.add(uf);
            }
        }
        return fs;
    }
    
    @Override
    public ArrayList<UploadFile> loadAll(String suffix) {
    	this.configurePath(suffix);
 //       try {
        	final File folder = new File(this.upload_dir);
            ArrayList<UploadFile> ls = listFiles(folder);                                                	
        	return ls;
//        	Stream<Path> ps = Files.walk(this.rootLocation, 1);
//        	ps.forEach(p -> {        		
//        		UploadFile uf = new UploadFile();
//        		uf.setName(p.getFileName().toString());
//        		uf.setPath(p.getFileName().toString());
//        		ufs.add(uf);
//        	});
        	
//            return Files.walk(this.rootLocation, 1)
//                    .filter(path -> !path.equals(this.rootLocation))
//                    .map(path -> this.rootLocation.relativize(path));
        	
//        } catch (IOException e) {
//            throw new StorageException("Failed to read stored files", e);
//        }

    }

    @Override
    public Path load(String suffix, String filename) {
    	this.configurePath(suffix);
        return rootLocation.resolve(filename);
    }

    @Override
    public Resource loadAsResource(String suffix, String filename) {
    	this.configurePath(suffix);
        try {
            Path file = load(suffix, filename);
            Resource resource = new UrlResource(file.toUri());
            if(resource.exists() || resource.isReadable()) {
                return resource;
            }
            else {
                throw new StorageFileNotFoundException("Could not read file: " + filename);

            }
        } catch (MalformedURLException e) {
            throw new StorageFileNotFoundException("Could not read file: " + filename, e);
        }
    }

    @Override
    public void deleteAll(String suffix) {
    	this.configurePath(suffix);
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }

    @Override
    public void init() {    	
//        try {        	
//            Files.createDirectory(rootLocation);
//        } catch (IOException e) {
//            throw new StorageException("Could not initialize storage", e);
//        }
    }
    
    private void configurePath(String suffix) {
    	this.upload_dir		= this.properties.getLocation() + suffix;
    	this.rootLocation 	= Paths.get(this.upload_dir);
    }
}
