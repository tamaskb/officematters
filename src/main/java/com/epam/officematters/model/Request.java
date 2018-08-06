package com.epam.officematters.model;

public class Request {
	
	private String fullName;
	private String emailAddress;
	private String subject;
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
