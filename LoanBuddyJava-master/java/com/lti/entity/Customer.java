package com.lti.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//import org.codehaus.jackson.map.ext.JodaDeserializers.LocalDateDeserializer;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name = "customer1")
public class Customer {
	@Id
	@SequenceGenerator(name = "cus_seq1", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "cus_seq1", strategy = GenerationType.SEQUENCE)
	int customerId;
	String customerName;
	String customerEmail;
	String customerPassword;
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	
	LocalDate customerDob;
	String aadharNumber;
	String panNumber;
	String phoneNumber;
	String organizationName;
	double customerIncome;
	EmployementTypeEnum employmentType;
	
	@OneToOne(mappedBy = "customer",cascade=CascadeType.ALL)
	Property property;
	
	@OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
	LoanApplication loanApp;
	

	public LoanApplication getLoanApp() {
		return loanApp;
	}

	public void setLoanApp(LoanApplication loanApp) {
		this.loanApp = loanApp;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public LocalDate getCustomerDob() {
		return customerDob;
	}

	public void setCustomerDob(String stringDob) {
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String date=stringDob;
		LocalDate localDate=LocalDate.parse(date, formatter);
		this.customerDob = localDate;
	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public double getCustomerIncome() {
		return customerIncome;
	}

	public void setCustomerIncome(double customerIncome) {
		this.customerIncome = customerIncome;
	}

	public EmployementTypeEnum getEmploymentType() {
		return employmentType;
	}

	public void setEmploymentType(EmployementTypeEnum employmentType) {
		this.employmentType = employmentType;
	}

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}
}
