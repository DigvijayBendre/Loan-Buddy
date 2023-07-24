package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.lti.entity.Contact;
import com.lti.entity.Customer;
@Component
public class ContactDaoImpl implements ContactDao {

	
	
	@PersistenceContext
	EntityManager em;
	
	public List<Contact> viewAllRequests() {
		// TODO Auto-generated method stub
		String jpql = "select u from Contact u";
		TypedQuery<Contact> query = em.createQuery(jpql, Contact.class);

		return query.getResultList();
		
	}

	public Contact viewRequestById(int cId) {
		// TODO Auto-generated method stub
		return em.find(Contact.class, cId);
	}

	@Transactional
	public Contact addRequest(Contact contact) {
		// TODO Auto-generated method stub
		Contact userPersisted = em.merge(contact);
		return userPersisted;
		
	}

}
