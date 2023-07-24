package com.lti.dao;

import com.lti.entity.Customer;
import com.lti.entity.Property;

public interface PropertyDao {
	
	Property viewPropertyByCustomerId(int customerId);
	Property searchPropertyByPropId(int propertyId);
	Property addPropertyForACustomer(Property property);
	Customer searchCustomer(int customerId);

}
