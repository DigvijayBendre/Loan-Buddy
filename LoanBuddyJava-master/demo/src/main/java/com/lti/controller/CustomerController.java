package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.LoginDto;
import com.lti.entity.Customer;
import com.lti.entity.Feedback;
import com.lti.service.CustomerService;

@RestController
@RequestMapping("/customers")
@CrossOrigin(origins = "*")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	// http://localhost:8181/LoanBuddy/myapp/customers/signup
	//@RequestMapping(value = "/signup",method = RequestMethod.POST)
	@PostMapping(value = "/signup")
	public String signup(@RequestBody Customer customer) {
		String message=customerService.registerNewCustomer(customer);
		return message;
	}
	@GetMapping("/customer/{customerId}")
	public Customer findCustomer(@PathVariable int customerId) {
		return customerService.findCustomer(customerId);
	}
	@GetMapping("/viewAllCustomers")
	public List<Customer> viewAllCustomers(){
		return customerService.viewAllCustomers();
	}
	@GetMapping("/sample")
	public void sample(){
		System.out.println("Sample Here.");
	}
	@PostMapping("/login")
	public boolean login(@RequestBody LoginDto loginDto) {
		return customerService.login(loginDto.getCustomerId(), loginDto.getCustomerPassword());
	}
	
	@PostMapping("/addFeedback")
	public String giveFeedbcak(@RequestBody Feedback feed) {
		return customerService.addFeed(feed);
	}
	
	@GetMapping("/seeAllFeedbacks")
	public List<Feedback> seeAllFeedbacks(){
		return customerService.viewAllFeed();
	}
	
	
}
