package com.epam.officematters.service.impl;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epam.officematters.model.Request;
import com.epam.officematters.repository.RequestRepository;
import com.epam.officematters.service.RequestService;
import com.epam.officematters.service.exception.RequestAlreadyExistsException;

@Service
public class RequestServiceImpl implements RequestService {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private RequestRepository repository;

	@Override
	@Transactional
	public void register(Request request) throws RequestAlreadyExistsException {

		logger.info("Registering request: {}", request);

		try {
			repository.save(request);
		} catch (RuntimeException duplicate) { // FIXME: add proper exception type

			throw new RequestAlreadyExistsException("This request already exists");
		}
	}

	@Override
	@Transactional
	public Request getRequestById(int id) {
		return repository.findRequestById(id);
	}

	@Override
	public List<Request> getNewRequests() {
		return repository.listNewRequests();
	}

	@Override
	public List<Request> getInprogressRequests() {
		return repository.listInProgressRequests();
	}

	@Override
	public List<Request> getResolvedRequests() {
		return repository.listResolvedRequests();
	}

	@Override
	public void changeRequestToInProgress(Request request, int id) {
		repository.pushRequestToInProgress(request, id);

	}

	@Override
	public List<Request> getNotTriagedRequests() {
		return repository.listNotTriagedRequests();
	}

	@Override
	public void changeRequestPriority(Request request, int id) {
		repository.setRequestPriority(request, id);
	}

}
