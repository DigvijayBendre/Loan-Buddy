package com.lti;

import static org.junit.jupiter.api.Assertions.assertNotNull;

//import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.*;
import org.junit.jupiter.api.*;
//import org.junit.Test;/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.dao.CustomerDao;
import com.lti.entity.Customer;
import com.lti.entity.EmployementTypeEnum;

public class CustomerDaoTest {

	CustomerDao dao;

	@BeforeAll
	public void initializeDao() {
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

		dao = context.getBean(CustomerDao.class);
	}

	@Test
	public void viewAllCustomers() {
		List<Customer> listCustomer = dao.viewAllCustomers();
		for (Customer i : listCustomer) {
			System.out.println(i.getCustomerId() + " " + i.getCustomerName() + " " + i.getCustomerEmail() + " " + i.getCustomerPassword() + " "
					+ i.getCustomerDob() + " " + i.getAadharNumber() + " " + i.getPanNumber() + " " + i.getPhoneNumber() + " "
					+ i.getOrganizationName() + " " + i.getCustomerIncome() + " " + i.getEmploymentType());
		}
		assertNotNull(listCustomer);
	}

	@Test
	public void addOrUpdateCustomerTest() {
		Customer customer = new Customer();
		customer.setCustomerName("Swati");
		customer.setCustomerEmail("swati@lti.com");
		customer.setCustomerPassword("Pass@123");
		customer.setCustomerDob("7/12/1999");
		customer.setAadharNumber("123445");
		customer.setPanNumber("BJK123");
		customer.setPhoneNumber("87864353");
		customer.setOrganizationName("LTI");
		customer.setCustomerIncome(132214);
		customer.setEmploymentType(EmployementTypeEnum.SALARIED);

		Customer savedUser = dao.addOrUpdateCustomer(customer);

		assertNotNull(savedUser);
	}

	@Test
	public void getCustomerByIdTest() {
		Customer customer = dao.getCustomerById(4);
		System.out.println(customer.getCustomerName());
		assertNotNull(customer);

	}

}
