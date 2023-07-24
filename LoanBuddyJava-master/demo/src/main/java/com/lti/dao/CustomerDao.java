package com.lti.dao;

import java.util.List;

import com.lti.entity.Customer;
import com.lti.entity.Feedback;

public interface CustomerDao {

	List<Customer> viewAllCustomers();

	Customer addOrUpdateCustomer(Customer customer);

	Customer getCustomerById(int customerId);
	
	boolean login(int customerId, String password);
	
	Feedback addFeed(Feedback feed);
	List<Feedback> viewAllFeed();
}
