package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.CustomerDao;
import com.lti.dao.PropertyDao;
import com.lti.entity.Customer;
import com.lti.entity.Property;
@Service
public class PropertyServiceImpl implements PropertyService {
	
	@Autowired
	PropertyDao propDao;
	CustomerDao custDao;
	
	public String addProperty(Property property) {
		// TODO Auto-generated method stub
		try {
//			Customer customer=custDao.getCustomerById(customerId);
//			System.out.println("Customer fetched");
//			property.setCustomer(customer);
//			System.out.println("Customer Set to prop");
			Property property1 =propDao.addPropertyForACustomer(property);
			//System.out.println("prop added and returned.");
			return "Property Added Succesfully.";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "Error Occured While Registration.";
		}
		
	}

	public Property getPropertyForACustomer(int customerId) {
		// TODO Auto-generated method stub
		return propDao.viewPropertyByCustomerId(customerId);
		
	}

}
