package com.lti.dto;

import org.springframework.web.multipart.MultipartFile;

public class DocumentsDto {

	int studentId;
	
	MultipartFile aadharCard;
	//MultipartFile tenthMarksheet;
	//MultipartFile twelfthMarksheet;
	//MultipartFile photo;
	//MultipartFile idCard;
	MultipartFile casteOrIncomeCertificate;
	//MultipartFile feeReciept;
	MultipartFile passBook;
	//MultipartFile domecile;
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public MultipartFile getAadharCard() {
		return aadharCard;
	}
	public void setAadharCard(MultipartFile aadharCard) {
		this.aadharCard = aadharCard;
	}
	
	public MultipartFile getCasteOrIncomeCertificate() {
		return casteOrIncomeCertificate;
	}
	public void setCasteOrIncomeCertificate(MultipartFile casteOrIncomeCertificate) {
		this.casteOrIncomeCertificate = casteOrIncomeCertificate;
	}
	
	public MultipartFile getPassBook() {
		return passBook;
	}
	public void setPassBook(MultipartFile passBook) {
		this.passBook = passBook;
	}
	
	
	
	
}
