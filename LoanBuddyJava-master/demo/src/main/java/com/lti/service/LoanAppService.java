package com.lti.service;

import java.util.List;

import com.lti.entity.LoanApplication;

public interface LoanAppService {
	String addLoanApplication(LoanApplication loanApp);
	List<LoanApplication> getAllApplications();
	LoanApplication getAppByCustId(int customerId);
	List<LoanApplication> approvedApplications();
	List<LoanApplication> rejectedApplications();
}
