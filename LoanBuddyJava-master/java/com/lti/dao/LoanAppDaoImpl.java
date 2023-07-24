package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.lti.entity.AppStatusEnum;
import com.lti.entity.Customer;
import com.lti.entity.LoanApplication;
@Repository
public class LoanAppDaoImpl implements LoanAppDao {

	@PersistenceContext
	EntityManager em;
	

	
	@Transactional
	public LoanApplication addOrUpdateApplication(LoanApplication loanApp) {
		// TODO Auto-generated method stub
		loanApp.setAppStatus(AppStatusEnum.SENT_FOR_VERIFICARION);
		LoanApplication loanAppPersisted=em.merge(loanApp);
		System.out.println(loanAppPersisted.getLoanAppId());
		System.out.println(loanAppPersisted.getCustomer().getCustomerId());
		return loanAppPersisted;
	}

	public List<LoanApplication> viewAllApplications() {
		// TODO Auto-generated method stub
		String jpql = "select u from LoanApplication u";
		TypedQuery<LoanApplication> query = em.createQuery(jpql, LoanApplication.class);

		return query.getResultList();
	
	}

	public LoanApplication getAppByCustomerId(int customerId) {
		// TODO Auto-generated method stub
		Customer c = searchCustomer(customerId);
		LoanApplication l = c.getLoanApp();
		l.setCustomer(null);
		return l;
	}

	

	public Customer searchCustomer(int customerId) {
		// TODO Auto-generated method stub
		return em.find(Customer.class, customerId);

	}

	public List<LoanApplication> viewApprovedApplications() {
		// TODO Auto-generated method stub
		String jpql="select ins from LoanApplication ins where ins.isApproved=:vt";
		Query query= em.createQuery(jpql);
		query.setParameter("vt",true);
		return query.getResultList();
		
	}

	public List<LoanApplication> viewRejectedApplications() {
		// TODO Auto-generated method stub
		String jpql="select ins from LoanApplication ins where ins.vehicleType=:vtf";
		Query query= em.createQuery(jpql);
		query.setParameter("vtf",false);
		return query.getResultList();
		
	}

}
