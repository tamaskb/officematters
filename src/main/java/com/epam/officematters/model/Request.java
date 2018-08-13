package com.epam.officematters.model;


import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Request {

	@NotBlank(message = "Please enter Your name!")
	private String fullName;

	@Email(message = "Please enter Your email address!")
	@NotNull(message = "Please enter Your email address!")
	private String emailAddress;

	@NotNull(message = "Please enter the subject of Your problem!")
	@Size(min = 3, max = 15, message = "Length restriction: minimum 3, maximum 15 characters!")
	private String subject;

	@NotNull(message = "Please describe Your problem!")
	@Size(min = 5, message = "Description must be at least 5 characters!")
	private String description;

	private int priority; // 0=not yet added, 1=high, 2=medium, 3=low

	@Id
	@GeneratedValue
	private int id;

	private int progressStatus; // 0=new, 1=in progress, 2=resolved
	
	private String comment;


	public Request() {

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

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getProgressStatus() {
		return progressStatus;
	}

	public void setProgressStatus(int progressStatus) {
		this.progressStatus = progressStatus;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Request [fullName=" + fullName + ", emailAddress=" + emailAddress + ", subject=" + subject
				+ ", description=" + description + "]";
	}

}
