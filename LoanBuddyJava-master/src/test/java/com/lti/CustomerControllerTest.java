package com.lti;

import static org.junit.jupiter.api.Assertions.assertFalse;

//import static org.junit.Assert;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.controller.CustomerController;
import com.lti.entity.Customer;
import com.lti.entity.EmployementTypeEnum;

public class CustomerControllerTest {

	static CustomerController controller;

	@BeforeAll
	public static void initialize() {
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

		controller = context.getBean(CustomerController.class);
	}

	@Test
	public void signupTest() {
		Customer customer = new Customer();
		customer.setCustomerName("Parth");
		customer.setCustomerEmail("Parth@gmail.com");
		customer.setCustomerDob("04/12/2000");
		customer.setAadharNumber("123445");
		customer.setPanNumber("BJK123");
		customer.setPhoneNumber("87864353");
		customer.setOrganizationName("LTI");
		customer.setCustomerIncome(132214);
		customer.setEmploymentType(EmployementTypeEnum.SALARIED);

		String actualMessage = controller.signup(customer);
		System.out.println(actualMessage);
	}

	@Test
	public void findCustomerTest() {
		Customer customer = controller.findCustomer(3);
		System.out
				.println("Customer Name - " + customer.getCustomerName() + "\n" + "Customer Id - " + customer.getCustomerId());

	}

	@Test
	public void viewAllCustomerTest() {
		List<Customer> customerList = controller.viewAllCustomers();
		assertFalse(customerList.isEmpty());
	}

}
