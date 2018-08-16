package com.epam.officematters.model;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Comment {
	
	@NotNull(message = "Please enter your comment")
	@Size(min=3, message = "Please enter your comment")
	private String commentMsg;
	
	@NotNull(message = "Please enter your name")
	@Size(min=3, message = "Please enter your name")
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
