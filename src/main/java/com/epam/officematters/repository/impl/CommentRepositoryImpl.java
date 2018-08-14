package com.epam.officematters.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.epam.officematters.model.Comment;
import com.epam.officematters.repository.CommentRepository;

@Repository
public class CommentRepositoryImpl implements CommentRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	@Transactional
	public void saveComment(Comment comment, int requestId) {
		
		final String sql = "INSERT INTO comments (author, comment, date, requestid) VALUES (?, ?, CURRENT_TIMESTAMP, ?)";
		jdbcTemplate.update(sql, comment.getAuthor(), comment.getCommentMsg(),  requestId);
	}

}
