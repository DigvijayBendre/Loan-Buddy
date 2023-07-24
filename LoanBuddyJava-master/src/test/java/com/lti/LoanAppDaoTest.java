package com.lti;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

//import static org.junit.Assert.*;

import java.util.List;

import org.junit.jupiter.*;
//import org.junit.Test;
import org.junit.jupiter.api.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.dao.CustomerDao;
import com.lti.dao.LoanAppDao;
import com.lti.dao.PropertyDao;
import com.lti.entity.Customer;
import com.lti.entity.LoanApplication;

public class LoanAppDaoTest {

	
	LoanAppDao dao;
	CustomerDao dao1;

	@BeforeAll
	public void initializeDao() {
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

		dao1 = context.getBean(CustomerDao.class);
		dao = context.getBean(LoanAppDao.class);
	}
	
	
	@Test
	public void addApplicationTest() {
		LoanApplication loanApp=new LoanApplication();
		loanApp.setMaxLoanGrant(15900000);
		loanApp.setLoanAmmount(900000);
		loanApp.setTenure(11);
		//loanApp.setApproved(false);
		//loanApp.setAppStatus("SENT_FOR_VERIFICATION");
		Customer customer = dao1.getCustomerById(1);
		System.out.println(customer.getCustomerName());
		loanApp.setCustomer(customer);
		
		LoanApplication loanAppPersisted=dao.addOrUpdateApplication(loanApp);
		assertNotNull(loanAppPersisted);
		
	}
	
	@Test
	public void viewAllApplicationsTest() {
		List<LoanApplication> listAppl = dao.viewAllApplications();
		for(LoanApplication i: listAppl) {
		System.out.println(i.getLoanAppId()+" "+i.getMaxLoanGrant()+" "
				+i.getLoanAmmount()+" "+i.getTenure()+" "+i.getCustomer().getCustomerName()+" "+i.getCustomer().getCustomerId()+" "+i.getCustomer().getCustomerIncome());	
		}
		assertNotNull(listAppl);
	}
	
	@Test
	public void  viewApplByCustomerId() {
		LoanApplication loanApp=dao.getAppByCustomerId(4);
		System.out.println(loanApp.getLoanAppId());
	}
	
	@Test
	public void getApprovedAppTest() {
		List<LoanApplication> ApprovedApplList = dao.viewApprovedApplications();
		for(LoanApplication i: ApprovedApplList) {
			System.out.println(i.getLoanAppId()+" "+i.getLoanAmmount());
		}
		assertNotNull(ApprovedApplList);
	}
	
	@Test
	public void getRejectedAppTest() {
		List<LoanApplication> ApprovedApplList0 = dao.viewRejectedApplications();
		for(LoanApplication i: ApprovedApplList0) {
			System.out.println(i.getLoanAppId()+" "+i.getLoanAmmount());
		}
		assertNotNull(ApprovedApplList0);
	}
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
