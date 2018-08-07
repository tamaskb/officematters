package com.epam.officematters.repository.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.epam.officematters.model.Request;
import com.epam.officematters.repository.RequestRepository;

@Repository
public class RequestRepositoryImpl implements RequestRepository {
	
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void save(Request request) {
		
		logger.info("saving now: {}" + request);
		
        final String sql = "INSERT INTO requests (name, email, subject, description) VALUES ( ?, ?, ?, ?)";
		jdbcTemplate.update(sql, request.getFullName(), request.getEmailAddress(), request.getSubject(), request.getDescription());
	}

}
