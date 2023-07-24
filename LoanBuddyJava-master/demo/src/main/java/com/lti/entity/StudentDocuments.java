package com.lti.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "nsp_studentDocuments")
public class StudentDocuments {

	@Id
	@SequenceGenerator(name = "studentDocuments_seq", allocationSize = 1, initialValue = 801)
	@GeneratedValue(generator = "studentDocuments_seq", strategy = GenerationType.SEQUENCE)
	int StudentDocumentsId;

	String aadharCard;
	//String tenthMarksheet;
	//String twelfthMarksheet;
	//String photo;
	//String idCard;
	String casteOrIncomeCertificate;
	//String feeReciept;
	String passBook;
	//String domecile;

	@OneToOne
	@JoinColumn(name = "customerId")
	Customer customer;

	public int getStudentDocumentsId() {
		return StudentDocumentsId;
	}

	public void setStudentDocumentsId(int studentDocumentsId) {
		StudentDocumentsId = studentDocumentsId;
	}

	public String getAadharCard() {
		return aadharCard;
	}

	public void setAadharCard(String aadharCard) {
		this.aadharCard = aadharCard;
	}



	public String getPassBook() {
		return passBook;
	}

	public void setPassBook(String passBook) {
		this.passBook = passBook;
	}

	public String getCasteOrIncomeCertificate() {
		return casteOrIncomeCertificate;
	}

	public void setCasteOrIncomeCertificate(String casteOrIncomeCertificate) {
		this.casteOrIncomeCertificate = casteOrIncomeCertificate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	
	

}
