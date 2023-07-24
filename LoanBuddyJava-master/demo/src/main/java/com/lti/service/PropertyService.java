package com.lti.service;

import java.util.List;

import com.lti.entity.Property;

public interface PropertyService {
	String addProperty(Property property);
	Property getPropertyForACustomer(int customerId);
}
