package com.lti.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name = "application_tbl")
public class LoanApplication {
	@Id
	@SequenceGenerator(name = "appl1_seq", initialValue = 504030201, allocationSize = 1)
	@GeneratedValue(generator = "appl1_seq", strategy = GenerationType.SEQUENCE)
	int loanAppId;
	double maxLoanGrant;
	int tenure;
	double loanAmmount;
	AppStatusEnum appStatus;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customerId")
	Customer customer;
	
	
	public AppStatusEnum getAppStatus() {
		return appStatus;
	}

	public void setAppStatus(AppStatusEnum appStatus) {
		this.appStatus = appStatus;
	}


	

	

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

	
	

	public int getLoanAppId() {
		return loanAppId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	

}
