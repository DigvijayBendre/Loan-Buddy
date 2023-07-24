package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.DocumentsDto;
import com.lti.service.DocumentServiceImpl;
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/documents")
public class DocumentController {
	
	@Autowired
	DocumentServiceImpl sas;
	
	
	
	@PostMapping("/uploadDoc")
	public String documentUpload(DocumentsDto dDto) {
		return sas.uploadDocuments(dDto);
	}
}
