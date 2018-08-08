package com.epam.officematters.repository.impl;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.epam.officematters.model.Request;
import com.epam.officematters.repository.RequestRepository;

@Repository
public class RequestRepositoryImpl implements RequestRepository {
	
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private final RowMapper<Request> mapper = new RowMapper<Request>() {

		@Override
		public Request mapRow(ResultSet rs, int rowNum) throws SQLException {
			Request r = new Request();
			r.setFullName(rs.getString("name"));
			r.setEmailAddress(rs.getString("email"));
			r.setSubject(rs.getString("subject"));
			r.setDescription(rs.getString("description"));
			return r;
		}
		
	};
	
	@Override
	public void save(Request request) {
		
		logger.info("saving now: {}" + request);
		
        final String sql = "INSERT INTO requests (name, email, subject, description) VALUES ( ?, ?, ?, ?)";
		jdbcTemplate.update(sql, request.getFullName(), request.getEmailAddress(), request.getSubject(), request.getDescription());
	}
	
	public List<Request> listRequests() {
		final String sql = "SELECT * FROM requests";
				
		return jdbcTemplate.query(sql, mapper);
	}


}
