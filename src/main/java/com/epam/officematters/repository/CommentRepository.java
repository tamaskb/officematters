package com.epam.officematters.repository;

import java.util.List;

import com.epam.officematters.model.Comment;

public interface CommentRepository {
	
	void saveComment(Comment comment, int requestId);
	
	List<Comment> listRequestComments(int requestId);

}
