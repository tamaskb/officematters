package com.epam.officematters.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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
		comment.setCurrentTime(Calendar.getInstance().getTime()); 
		jdbcTemplate.update(sql, comment.getAuthor(), comment.getCommentMsg(),  requestId);
	}

	
	private final RowMapper<Comment> commentMapper = new RowMapper<Comment>() {

		public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {
			Comment c = new Comment();
			c.setAuthor(rs.getString("author"));
			c.setCommentMsg(rs.getString("comment"));
			c.setCurrentTime(rs.getDate("date"));
			return c;
		}
	};
	
	@Override
	public List<Comment> listRequestComments(int requestId) {
		final String sql = "SELECT author, comment, date FROM comments WHERE requestid =" + requestId;
		return jdbcTemplate.query(sql, commentMapper);
	}

}
