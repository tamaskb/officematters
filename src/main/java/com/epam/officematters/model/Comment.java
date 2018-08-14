package com.epam.officematters.model;

import java.util.Date;

public class Comment {
	
	private String commentMsg;
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

}
