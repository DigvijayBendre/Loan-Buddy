package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.ContactDao;
import com.lti.entity.Contact;
@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	ContactDao contactDao;
	
	
	public String recieveContactRequest(Contact contact) {
		// TODO Auto-generated method stub
		try {
			Contact contact1=contactDao.addRequest(contact);
			return "Request Added.";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "Request Not Added.";
		}
		
	}

	public Contact searchReqById(int cId) {
		// TODO Auto-generated method stub
		Contact c=contactDao.viewRequestById(cId);
		return c;
	}

	public List<Contact> viewAllReq() {
		// TODO Auto-generated method stub
		List<Contact> c=contactDao.viewAllRequests();
		return c;
	}

}
