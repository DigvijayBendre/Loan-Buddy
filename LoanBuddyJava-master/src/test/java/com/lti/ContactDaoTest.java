package com.lti;

//import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.dao.ContactDao;
import com.lti.entity.Contact;
import com.lti.entity.Customer;


public class ContactDaoTest {

	
	ContactDao dao;

	@BeforeAll
	public void initializeDao() {
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

		dao = context.getBean(ContactDao.class);
	}
	
	@Test
	public void viewAllReqTest() {
		List<Contact> listReq=dao.viewAllRequests();
		
		for(Contact i:listReq) {
			System.out.println(i.getMessage()+" "+i.getName()+" "+i.getEmail());
			assertNotNull(listReq);
		}
	}
	
	@Test
	public void addReqtest()
	{
		Contact c = new Contact();
		c.setName("Harsha");
		c.setEmail("abc@g.com");
		c.setMessage("I am Fine");
		
		Contact savedReq=dao.addRequest(c);
		assertNotNull(savedReq);
	}
	
	
	@Test
	public void getReqById() {
		Contact contact = dao.viewRequestById(2);
		System.out.println(contact.getName()+" "+contact.getMessage());
		assertNotNull(contact);
	}
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
