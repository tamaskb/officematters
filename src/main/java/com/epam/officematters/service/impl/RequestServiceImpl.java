package com.epam.officematters.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epam.officematters.model.Request;
import com.epam.officematters.repository.RequestRepository;
import com.epam.officematters.service.RequestService;

@Service
public class RequestServiceImpl implements RequestService {
	
	@Autowired
	private RequestRepository repository;
	
	@Override
	@Transactional
	public void register(Request request) {
		
		repository.save(request);
	}

}
