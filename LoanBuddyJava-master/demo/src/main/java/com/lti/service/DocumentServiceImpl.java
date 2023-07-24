package com.lti.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import com.lti.dao.CustomerDao;
import com.lti.dao.StudentDocumentsDao;
import com.lti.dto.DocumentsDto;
import com.lti.entity.Customer;
import com.lti.entity.StudentDocuments;

@Service
public class DocumentServiceImpl {
	
	@Autowired
	CustomerDao daoc;
	@Autowired 
	StudentDocumentsDao daoDoc;
	
public String uploadDocuments(DocumentsDto dDto) {
		
		StudentDocuments sd = new StudentDocuments();
		Customer stu = daoc.getCustomerById(dDto.getStudentId());
		
		sd.setAadharCard(dDto.getAadharCard().getOriginalFilename());
//		sd.setTwelfthMarksheet(dDto.getTwelfthMarksheet().getOriginalFilename());
		//sd.setPhoto(dDto.getPhoto().getOriginalFilename());
		//sd.setIdCard(dDto.getIdCard().getOriginalFilename());
		sd.setCasteOrIncomeCertificate(dDto.getCasteOrIncomeCertificate().getOriginalFilename());
		//sd.setFeeReciept(dDto.getFeeReciept().getOriginalFilename());
		sd.setPassBook(dDto.getPassBook().getOriginalFilename());
		//sd.setDomecile(dDto.getDomecile().getOriginalFilename());
		sd.setCustomer(stu);
		
		String imageUploadLocation = "E:/Project/temp/uploads"+dDto.getStudentId()+"/";
		File f = new File(imageUploadLocation);
		if (!f.exists()) {
			f.mkdir();
		}
		String tAadharCard = imageUploadLocation + dDto.getAadharCard().getOriginalFilename();
		//String tTenthMarksheet = imageUploadLocation + dDto.getTenthMarksheet().getOriginalFilename();
		//String tTwelfthMarksheet = imageUploadLocation + dDto.getTwelfthMarksheet().getOriginalFilename();
		//String tPhoto = imageUploadLocation + dDto.getPhoto().getOriginalFilename();
		//String tIdCard = imageUploadLocation + dDto.getIdCard().getOriginalFilename();
		String tCasteOrIncomeCertificate = imageUploadLocation + dDto.getCasteOrIncomeCertificate().getOriginalFilename();
		//String tFeeReciept = imageUploadLocation + dDto.getFeeReciept().getOriginalFilename();
		String tPassBook = imageUploadLocation + dDto.getPassBook().getOriginalFilename();
		//String tDomecile = imageUploadLocation + dDto.getDomecile().getOriginalFilename();

		try {
            FileCopyUtils.copy(dDto.getAadharCard().getInputStream(), new FileOutputStream(tAadharCard));
            //FileCopyUtils.copy(dDto.getTenthMarksheet().getInputStream(), new FileOutputStream(tTenthMarksheet));
           // FileCopyUtils.copy(dDto.getTwelfthMarksheet().getInputStream(), new FileOutputStream(tTwelfthMarksheet));
           // FileCopyUtils.copy(dDto.getPhoto().getInputStream(), new FileOutputStream(tPhoto));
           // FileCopyUtils.copy(dDto.getIdCard().getInputStream(), new FileOutputStream(tIdCard));
            FileCopyUtils.copy(dDto.getCasteOrIncomeCertificate().getInputStream(), new FileOutputStream(tCasteOrIncomeCertificate));
            //FileCopyUtils.copy(dDto.getFeeReciept().getInputStream(), new FileOutputStream(tFeeReciept));
           //FileCopyUtils.copy(dDto.getPassBook().getInputStream(), new FileOutputStream(tDomecile));
            FileCopyUtils.copy(dDto.getPassBook().getInputStream(), new FileOutputStream(tPassBook));
        } catch (IOException e) {
            e.printStackTrace();
            return e.getMessage();
        }
		try {
			daoDoc.addOrUpdateStudentDocuments(sd);
			return "Success";
		} catch (Exception e) {
			return "Unexpected Error Occured";
		}
		
	}
	
}
