package com.epam.officematters.service.impl;

import java.util.List;

import com.epam.officematters.service.exception.CommentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.officematters.model.Comment;
import com.epam.officematters.repository.CommentRepository;
import com.epam.officematters.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private CommentRepository commentRepo;
	
	@Override
	public Comment registerComment(Comment comment, int requestId) {
		logger.info("saving comment: " + comment);
		return commentRepo.saveComment(comment, requestId);
	}

	@Override
	public List<Comment> getRequestComments(int requestId) {
		return commentRepo.listRequestComments(requestId);
	}

}
