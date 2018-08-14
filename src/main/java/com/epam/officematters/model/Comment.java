package com.epam.officematters.model;

import java.util.Date;

import javax.validation.constraints.NotBlank;

public class Comment {
	
	@NotBlank(message = "Please enter your comment")
	private String commentMsg;
	
	@NotBlank(message = "Please enter your name")
	private String author;
	
	private Date currentTime;
	
	public Comment () {
		
	}
	
	public Comment(String commentMsg, String author, Date currentTime) {
		super();
		this.commentMsg = commentMsg;
		this.author = author;
		this.currentTime = currentTime;
	}
	
	
	public String getCommentMsg() {
		return commentMsg;
	}
	public void setCommentMsg(String commentMsg) {
		this.commentMsg = commentMsg;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getCurrentTime() {
		return currentTime;
	}
	public void setCurrentTime(Date currentTime) {
		this.currentTime = currentTime;
	}

	@Override
	public String toString() {
		return "Comment [commentMsg=" + commentMsg + ", author=" + author + ", currentTime=" + currentTime + "]";
	}
	
	

}
