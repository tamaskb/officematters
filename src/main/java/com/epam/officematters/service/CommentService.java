package com.epam.officematters.service;

import com.epam.officematters.model.Comment;

public interface CommentService {
	
	void registerComment(Comment comment, int requestId);

}
