package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.lti.entity.StudentDocuments;
@Component
public class StudentDocImpl implements StudentDocumentsDao {

	@PersistenceContext
	EntityManager em;
	
	@Transactional
	public StudentDocuments addOrUpdateStudentDocuments(StudentDocuments studentDocuments) {
		// TODO Auto-generated method stub
		return em.merge(studentDocuments);
	}

	
	public StudentDocuments searchStudentDocumentsById(int studentDocumentsId) {
		// TODO Auto-generated method stub
		return em.find(StudentDocuments.class, studentDocumentsId)	;}

	
	public StudentDocuments searchStudentDocumentsByStudentId(int customerId) {
		// TODO Auto-generated method stub
		String jpql = "Select sd from StudentDocuments sd where sd.customer.customerId=:sid";
		TypedQuery<StudentDocuments> query = em.createQuery(jpql, StudentDocuments.class);
		query.setParameter("sid", customerId);
		return query.getSingleResult();
	}

}
