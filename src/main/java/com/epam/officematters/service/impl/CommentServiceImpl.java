package com.epam.officematters.service.impl;

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
	public void registerComment(Comment comment, int requestId) {
		logger.info("saving comment: " + comment);
		commentRepo.saveComment(comment, requestId);
		
	}

}
