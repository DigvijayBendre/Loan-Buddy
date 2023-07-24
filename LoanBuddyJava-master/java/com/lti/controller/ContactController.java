package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dao.CustomerDao;
import com.lti.entity.Contact;
import com.lti.service.ContactService;
import com.lti.service.CustomerService;
import com.lti.service.PropertyService;

@RestController
@RequestMapping("/contactUs")
public class ContactController {

	
	@Autowired
	CustomerService customerService;
	@Autowired
	PropertyService propertyService;
	CustomerDao dao1;
	@Autowired
	ContactService contactService;
	
	@PostMapping(value="/getcontact")
	public String getContact(@RequestBody Contact contact) {
		return contactService.recieveContactRequest(contact);
	}
	
	@GetMapping("/searchReq/{cId}")
	public Contact searchForRequest(@PathVariable int cId ) {
		return contactService.searchReqById(cId);
	}
	
	@GetMapping("/viewAllReq")
	public List<Contact> viewAllRequests(){
		return contactService.viewAllReq();
	}
}
