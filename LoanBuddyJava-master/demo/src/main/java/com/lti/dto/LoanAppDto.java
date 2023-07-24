package com.lti.dto;

import com.lti.entity.LoanApplication;

public class LoanAppDto {
	int customerId;
	LoanApplication loanApp;
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public LoanApplication getLoanApp() {
		return loanApp;
	}
	public void setLoanApp(LoanApplication loanApp) {
		this.loanApp = loanApp;
	}
	
	
}
