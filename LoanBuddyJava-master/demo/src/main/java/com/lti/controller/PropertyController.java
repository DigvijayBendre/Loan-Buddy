package com.lti.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dao.CustomerDao;
import com.lti.entity.Customer;
import com.lti.entity.Property;
import com.lti.service.ContactService;
import com.lti.service.CustomerService;
import com.lti.service.PropertyService;


@RestController
@RequestMapping("/properties")
public class PropertyController {
	
	@PersistenceContext
	EntityManager em;
	
	@Autowired
	CustomerService customerService;
	@Autowired
	PropertyService propertyService;
	
	@Autowired
	CustomerDao dao1;
	@Autowired
	ContactService contactService;
	
	@GetMapping("/viewPropertyOfCustomer/{customerId}")
	public Property viewPropCustomer(@PathVariable int customerId) {
		return propertyService.getPropertyForACustomer(customerId);
	}
	
	@PostMapping(value = "/addProperty")
	public String addProperty(@RequestBody PropAndCustMerge merged)
	{
		Property property1=merged.getProperty();
//		Customer customer = dao1.getCustomerById(merged.getCustomerId());
		Customer customer = searchCustomerById(merged.getCustomerId());
		System.out.println(customer.getCustomerName());
		property1.setCustomer(customer);
		System.out.println(property1.getCustomer().getCustomerName());
//		int customerId=merged.customerId;
		return propertyService.addProperty(property1);
	}

	private Customer searchCustomerById(int customerId) {
		// TODO Auto-generated method stub
		
		return em.find(Customer.class, customerId);
	}
	
}
