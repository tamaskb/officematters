package com.epam.officematters.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

	private final RowMapper<Request> requestMapper = new RowMapper<Request>() {

		public Request mapRow(ResultSet rs, int rowNum) throws SQLException {
			Request r = new Request();
			r.setId(rs.getInt("id"));
			r.setFullName(rs.getString("name"));
			r.setEmailAddress(rs.getString("email"));
			r.setSubject(rs.getString("subject"));
			r.setDescription(rs.getString("description"));
			r.setProgressStatus(rs.getInt("progress"));
			r.setPriority(rs.getInt("priority"));
			return r;
		}
	};

	@Override
	@Transactional
	public void save(Request request) {

		logger.info("saving now: " + request);

		final String sql = "INSERT INTO requests (name, email, subject, description, progress, priority) VALUES ( ?, ?, ?, ?, 0, 0)";
		request.setProgressStatus(0);
		request.setPriority(0);
		jdbcTemplate.update(sql, request.getFullName(), request.getEmailAddress(), request.getSubject(),
				request.getDescription());
	}

	@Override
	public Request findRequestById(int id) {
		logger.info("found request by id: " + id);

		final String sql = "SELECT * FROM requests WHERE id = " + id;

		return jdbcTemplate.queryForObject(sql, requestMapper);

	}

	@Override
	public List<Request> listNewRequests() {
		final String sql = "SELECT * FROM requests WHERE progress = 0 ORDER BY priority ASC";
		return jdbcTemplate.query(sql, requestMapper);
	}

	@Override
	public List<Request> listInProgressRequests() {
		final String sql = "SELECT * FROM requests WHERE progress = 1";
		return jdbcTemplate.query(sql, requestMapper);
	}

	@Override
	public List<Request> listResolvedRequests() {
		final String sql = "SELECT * FROM requests WHERE progress = 2";
		return jdbcTemplate.query(sql, requestMapper);
	}

	@Override
	public void pushRequestToInProgress(Request request, int id) {
		final String sql = "UPDATE requests SET progress = 1 WHERE id = " + id;
		request.setProgressStatus(1);
		jdbcTemplate.update(sql);
	}
	
	@Override
	public void pushRequestToResolved(Request request, int id) {
		final String sql = "UPDATE requests SET progress = 2 WHERE id = " + id;
		request.setProgressStatus(2);
		jdbcTemplate.update(sql);
	}

	@Override
	public List<Request> listNotTriagedRequests() {
		final String sql = "SELECT * FROM requests WHERE priority = 0";
		return jdbcTemplate.query(sql, requestMapper);
	}

	@Override
	public void setRequestPriority(Request request, int id) {
		final String sql = "UPDATE requests SET priority = ? WHERE id =" + id;
		jdbcTemplate.update(sql, request.getPriority());

	}

	@Override
	public void getComment(Request request, int id) {
		final String sql ="INSERT INTO comments (comment, requestid) VALUES (?, ?)";
		jdbcTemplate.update(sql, request.getComment(), id);
	}

	

}
