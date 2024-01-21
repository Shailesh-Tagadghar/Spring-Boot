package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;




@RestController
public class FileController {
	@Autowired
	private FileService service;
	
	@PostMapping("/files/upload")
	public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file){
		String fileName = "";
		try {
			fileName = service.uploadFile(file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String downloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
				.path("/files/download/")
				.path(fileName)
				.toUriString();
		return new ResponseEntity<>(downloadUri,HttpStatus.OK);
	}
	
	@GetMapping("/files/download/{filename}")
	public ResponseEntity<?> downloadFile(@PathVariable String filename){
		Resource resource = null;
		try {
			resource = service.downloadFile(filename);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION,
						"attachment; filename=\"" + filename + "\"")
				.body(resource);
	}
}
