package com.lti.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name = "contact_us")
public class Contact {
	@Id
	@SequenceGenerator(name = "cont_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "cont_seq", strategy = GenerationType.SEQUENCE)
	int cID;
	String name;
	String email;
	String message;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getcID() {
		return cID;
	}
	
	
	
	
}
