package com.epam.officematters.service;

import java.util.List;

import com.epam.officematters.model.Comment;
import com.epam.officematters.service.exception.CommentException;

public interface CommentService {
	
	Comment registerComment(Comment comment, int requestId);
	
	List<Comment> getRequestComments(int requestId);

}
