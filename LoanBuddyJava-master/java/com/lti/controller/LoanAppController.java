package com.lti.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dao.CustomerDao;
import com.lti.dto.LoanAppDto;
import com.lti.entity.Customer;
import com.lti.entity.LoanApplication;
import com.lti.service.ContactService;
import com.lti.service.CustomerService;
import com.lti.service.LoanAppService;
import com.lti.service.PropertyService;

@RestController
@RequestMapping("/application")
@CrossOrigin(origins = "*")
public class LoanAppController {

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
	
	@Autowired
	LoanAppService loanService;
	
	@PostMapping("/addApplication")
	public String addLoanApplication(@RequestBody LoanAppDto dto) {
		LoanApplication loanApp = new LoanApplication();
		loanApp.setAppStatus(dto.getAppStatus());
		loanApp.setLoanAmmount(dto.getLoanAmmount());
		loanApp.setMaxLoanGrant(dto.getMaxLoanGrant());

//		Customer customer = dao1.getCustomerById(dto.getCustomerId());
		Customer customer = searchCustomerById(dto.getCustomerId());
		loanApp.setCustomer(customer);
//		customer.setLoanApp(loanApp);
		
		return loanService.addLoanApplication(loanApp);
	}
	
	@GetMapping("/allApplications")
	public List<LoanApplication> seeAllApplications()
	{
		return loanService.getAllApplications();
	}
	
	@GetMapping("/applicationForCust/{customerId}")
	public LoanApplication seeAppForCustomer(@PathVariable int customerId) {
		return loanService.getAppByCustId(customerId);
	}
	
	
	@GetMapping("/approvedApp")
	public List<LoanApplication> seeApproved() {
		return loanService.approvedApplications();
	}
	
	@GetMapping("/rejectedApp")
	public List<LoanApplication> seeRejected() {
		return loanService.rejectedApplications();
	}
	
	private Customer searchCustomerById(int customerId) {
		// TODO Auto-generated method stub
		
		return em.find(Customer.class, customerId);
	}
	
	
	
	
}
