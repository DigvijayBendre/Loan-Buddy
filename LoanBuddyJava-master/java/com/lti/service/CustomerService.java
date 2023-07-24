package com.lti.service;

import java.util.List;

import com.lti.entity.Customer;

public interface CustomerService {

	String registerNewCustomer(Customer customer);

	Customer findCustomer(int customerId);

	List<Customer> viewAllCustomers();
	
	boolean login(int customerId,String password);

}
