package com.lti;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

//import static org.junit.Assert.*;

import java.util.List;

import org.junit.jupiter.*;
//import org.junit.Test;
import org.junit.jupiter.api.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.dao.CustomerDao;
import com.lti.dao.CustomerDaoImpl;
import com.lti.dao.PropertyDao;
import com.lti.dao.PropertyDaoImpl;
import com.lti.entity.Customer;
import com.lti.entity.Property;
import com.lti.entity.PropertyType;

public class PropertyDaoTest {

	PropertyDao dao;
	CustomerDao dao1;

	@BeforeAll
	public void initializeDao() {
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

		dao1 = context.getBean(CustomerDao.class);
		dao = context.getBean(PropertyDao.class);
	}
	
	@Test
	public void searchPropertyByPropIdTest() {
		Property property=dao.searchPropertyByPropId(100005);
		System.out.println(property.getPropertyLocation());
	}

	@Test
	public void viewPropertyByCustomerIdTest() {

		Property property = dao.viewPropertyByCustomerId(4);
		System.out.println(property.getPropertyLocation());
		assertNotNull(property);
	}

	@Test
	public void addPropertyForACustomer() {

		Property property = new Property();
		property.setPropertyLocation("USA");
		property.setPropertyAmount(500);
		property.setPropertyType(PropertyType.RESIDENTIAL);
		System.out.println("Hii");
		Customer customer = dao1.getCustomerById(6);
		// List<Customer> c=dao1.viewAllCustomers();
		// System.out.println(c);
		// assertNotNull(customer);
		System.out.println(customer.getCustomerName());
		property.setCustomer(customer);

		Property propertyPersisted = dao.addPropertyForACustomer(property);
		assertNotNull(propertyPersisted);
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
