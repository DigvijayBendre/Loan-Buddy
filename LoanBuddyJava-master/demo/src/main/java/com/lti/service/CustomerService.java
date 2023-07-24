package com.lti.service;

import java.util.List;

import com.lti.entity.Customer;
import com.lti.entity.Feedback;

public interface CustomerService {

	String registerNewCustomer(Customer customer);

	Customer findCustomer(int customerId);

	List<Customer> viewAllCustomers();
	
	boolean login(int customerId,String password);

	String addFeed(Feedback feed) ;
	List<Feedback> viewAllFeed();

}
