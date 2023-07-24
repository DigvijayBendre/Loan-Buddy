package com.lti.controller;

import com.lti.entity.Property;

public class PropAndCustMerge {
	Property property;
	int customerId;
	public Property getProperty() {
		return property;
	}
	public void setProperty(Property property) {
		this.property = property;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
}
