package com.lti.dto;

import com.lti.entity.AppStatusEnum;
import com.lti.entity.LoanApplication;

public class LoanAppDto {
	int customerId;
//	LoanApplication loanApp;
	
	double maxLoanGrant;
	int tenure;
	double loanAmmount;
	AppStatusEnum appStatus;
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
//	public LoanApplication getLoanApp() {
//		return loanApp;
//	}
//	public void setLoanApp(LoanApplication loanApp) {
//		this.loanApp = loanApp;
//	}
	public double getMaxLoanGrant() {
		return maxLoanGrant;
	}
	public void setMaxLoanGrant(double maxLoanGrant) {
		this.maxLoanGrant = maxLoanGrant;
	}
	public int getTenure() {
		return tenure;
	}
	public void setTenure(int tenure) {
		this.tenure = tenure;
	}
	public double getLoanAmmount() {
		return loanAmmount;
	}
	public void setLoanAmmount(double loanAmmount) {
		this.loanAmmount = loanAmmount;
	}
	public AppStatusEnum getAppStatus() {
		return appStatus;
	}
	public void setAppStatus(AppStatusEnum appStatus) {
		this.appStatus = appStatus;
	}
	
	
}
