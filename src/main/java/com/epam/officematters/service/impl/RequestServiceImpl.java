package com.epam.officematters.service.impl;

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
	public void register(Request request) throws RequestAlreadyExistsException{
		
		logger.info("Registering request: {}", request);
		
		try {
		repository.save(request);
		} catch (RuntimeException duplicate) { //FIXME: add proper exception type
			
			throw new RequestAlreadyExistsException("This request already exists");
		}
	}

}
