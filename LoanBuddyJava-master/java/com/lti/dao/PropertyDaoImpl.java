package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.lti.entity.Customer;
import com.lti.entity.Property;

@Component
public class PropertyDaoImpl implements PropertyDao {

	@PersistenceContext
	EntityManager em;



	public Property viewPropertyByCustomerId(int customerId) {
		// TODO Auto-generated method stub
		Customer c = searchCustomer(customerId);
		//System.out.println(c.getName() + " " + c.getEmail());
		Property p = c.getProperty();
		p.setCustomer(null);
		//System.out.println(p.getPropertyLocation());
		return p;
		// return dao1.getCustomerById(customerId).getProperty();

	}

	@Transactional
	public Property addPropertyForACustomer(Property property) {
		// TODO Auto-generated method stub
		Property propPersisted = em.merge(property);
		return propPersisted;

	}

	public Property searchPropertyByPropId(int propertyId) {
		// TODO Auto-generated method stub
		return em.find(Property.class, propertyId);
	}

	public Customer searchCustomer(int customerId) {
		// TODO Auto-generated method stub
		return em.find(Customer.class, customerId);
	}

}
