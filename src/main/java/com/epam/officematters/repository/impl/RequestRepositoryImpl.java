package com.epam.officematters.repository.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.epam.officematters.model.Request;
import com.epam.officematters.repository.RequestRepository;

@Repository
public class RequestRepositoryImpl implements RequestRepository {
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void save(Request request) {
		
        final String sql = "INSERT INTO requests (id, name, email, subject, description) VALUES (?, ?, ?, ?, ?)";
        final String id = UUID.randomUUID().toString();
		jdbcTemplate.update(sql, id, request.getFullName(), request.getEmailAddress(), request.getSubject(), request.getDescription());
		System.out.println(request.getFullName());
	}

}
