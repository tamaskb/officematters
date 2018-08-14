package com.epam.officematters.repository;

import com.epam.officematters.model.Comment;

public interface CommentRepository {
	
	void saveComment(Comment comment, int requestId);

}
