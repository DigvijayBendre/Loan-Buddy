package com.lti.dao;

import java.util.List;

import com.lti.entity.Contact;

public interface ContactDao {
	List<Contact> viewAllRequests();
	Contact viewRequestById(int cId);
	Contact addRequest(Contact contact);
}
