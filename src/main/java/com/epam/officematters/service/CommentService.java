package com.epam.officematters.service;

import java.util.List;

import com.epam.officematters.model.Comment;

public interface CommentService {
	
	void registerComment(Comment comment, int requestId);
	
	List<Comment> getRequestComments(int requestId);

}
