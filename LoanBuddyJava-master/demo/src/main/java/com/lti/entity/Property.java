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
@Table(name = "property_tbl")
public class Property {
	@Id
	@SequenceGenerator(name = "prop_seq", initialValue = 100001, allocationSize = 1)
	@GeneratedValue(generator = "prop_seq", strategy = GenerationType.SEQUENCE)
	int propertyId;
	String propertyLocation;
	double propertyAmount;
	PropertyType propertyType;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customerId")
	Customer customer;

	public String getPropertyLocation() {
		return propertyLocation;
	}

	public void setPropertyLocation(String propertyLocation) {
		this.propertyLocation = propertyLocation;
	}

	public double getPropertyAmount() {
		return propertyAmount;
	}

	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setPropertyAmount(double i) {
		this.propertyAmount = i;
	}

	public PropertyType getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(PropertyType propertyType) {
		this.propertyType = propertyType;
	}

	public int getPropertyId() {
		return propertyId;
	}

	public Customer getCustomer() {
		return customer;
	}

}