package com.lti.dao;

import com.lti.entity.StudentDocuments;

public interface StudentDocumentsDao {
	StudentDocuments addOrUpdateStudentDocuments(StudentDocuments studentDocuments);

	StudentDocuments searchStudentDocumentsById(int studentDocumentsId);

	StudentDocuments searchStudentDocumentsByStudentId(int customerId);
}
