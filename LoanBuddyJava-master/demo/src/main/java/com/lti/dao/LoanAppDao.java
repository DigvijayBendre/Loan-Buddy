package com.lti.dao;

import java.util.List;

import com.lti.entity.Customer;
import com.lti.entity.LoanApplication;

public interface LoanAppDao {
	LoanApplication addOrUpdateApplication(LoanApplication loanApp);
	List<LoanApplication> viewAllApplications();
	LoanApplication getAppByCustomerId(int customerId);
	
	Customer searchCustomer(int customerId);
	List<LoanApplication> viewApprovedApplications();
	List<LoanApplication> viewRejectedApplications();
	
}
