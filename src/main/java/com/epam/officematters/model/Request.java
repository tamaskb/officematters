package com.epam.officematters.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



public class Request {
	
	@NotNull
	private String fullName;
	
	@Email
	@NotNull
	private String emailAddress;
	
	@NotNull
	@Size(min=3, max=15)
	private String subject;
	
	@NotNull
	@Size(min=5)
	private String description;
	
	public Request () {
		
	}
		
	public Request(String fullName, String emailAddress, String subject, String description) {
		super();
		this.fullName = fullName;
		this.emailAddress = emailAddress;
		this.subject = subject;
		this.description = description;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Request [fullName=" + fullName + ", emailAddress=" + emailAddress + ", subject=" + subject
				+ ", description=" + description + "]";
	}
	
	

}
