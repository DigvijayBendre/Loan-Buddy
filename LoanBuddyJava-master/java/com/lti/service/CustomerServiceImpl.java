package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.CustomerDao;
import com.lti.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao customerDao;

	@Autowired
	EmailService emailService;
	
	public String registerNewCustomer(Customer customer) {
		try{
			Customer customer2 = customerDao.addOrUpdateCustomer(customer);
			String text = "Registration successful. Your user id is "+customer2.getCustomerId();
			String subject = "Registration confirmation";
			String email = customer2.getCustomerEmail();
			emailService.sendEmailForSignUp(email, text, subject);
			System.out.println("Email sent successfully");
			return "Signup successful";
		}catch (Exception e) {
			// TODO: handle exception
			return "Signup failed";
		}

	}

	public Customer findCustomer(int customerId) {
		// TODO Auto-generated method stub
		Customer customer2 = customerDao.getCustomerById(customerId);
		return customer2;
	}

	public List<Customer> viewAllCustomers() {
		// TODO Auto-generated method stub
		List<Customer> customerList = customerDao.viewAllCustomers();
		return customerList;
	}
	
	public boolean login(int customerId, String password) {
		return customerDao.login(customerId, password);
	}

}
