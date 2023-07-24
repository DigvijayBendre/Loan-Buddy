package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.LoanAppDao;
import com.lti.entity.LoanApplication;
@Service
public class LoanAppServiceImpl implements LoanAppService {

	@Autowired
	LoanAppDao loanappDao;
	
	public String addLoanApplication(LoanApplication loanApp) {
		// TODO Auto-generated method stub
		try {
			
			LoanApplication l = loanappDao.addOrUpdateApplication(loanApp);
			return "Loan Application Added.";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "Loan Application Not Added.";
		}
		
	
	}

	public List<LoanApplication> getAllApplications() {
		// TODO Auto-generated method stub
		return loanappDao.viewAllApplications();
	}

	public LoanApplication getAppByCustId(int customerId) {
		// TODO Auto-generated method stub
		return loanappDao.getAppByCustomerId(customerId);
	}

	public List<LoanApplication> approvedApplications() {
		// TODO Auto-generated method stub
		return loanappDao.viewApprovedApplications();
	}

	public List<LoanApplication> rejectedApplications() {
		// TODO Auto-generated method stub
		return loanappDao.viewRejectedApplications();
	}

}
