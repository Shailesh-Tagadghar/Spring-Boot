package com.example.demo;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;



@Service
public class FileService {
	
	private Path rootLocation;
	
	public FileService(FileStorageProperties properties) {
		this.rootLocation = Paths.get(properties.getUploadDir());
	}
	
	
	public String uploadFile(MultipartFile file) throws Exception {
		String fileName = "";
		
		//System.out.println("Within service class uploadFile");
		
		if(file.isEmpty()) {
			throw new Exception("Can not upload empty file");
		}
		Path destinationPath = this.rootLocation.resolve(file.getOriginalFilename());

		try(InputStream fis = file.getInputStream()){
			Files.copy(fis, destinationPath, StandardCopyOption.REPLACE_EXISTING);
			fileName = file.getOriginalFilename();
			System.out.println("fileName : "+fileName);
			return fileName;
		}
		catch (Exception e) {
			throw new Exception("File could not be copied !!");
		}	
	}
	
	public Resource downloadFile(String filename) throws Exception {
		try {
			Path file = this.rootLocation.resolve(filename);
			Resource resource = new UrlResource(file.toUri());
			return resource;
		}
		catch (MalformedURLException e){
			throw new Exception("File cant be downloaded !!");
		}
	}
	
}
