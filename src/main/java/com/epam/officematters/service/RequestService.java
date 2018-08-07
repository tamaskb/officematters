package com.epam.officematters.service;

import com.epam.officematters.model.Request;
import com.epam.officematters.service.exception.RequestAlreadyExistsException;

public interface RequestService {
	
	void register(Request request) throws RequestAlreadyExistsException;
	
}
