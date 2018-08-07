package com.epam.officematters.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.epam.officematters.model.Request;
import com.epam.officematters.service.exception.RequestAlreadyExistsException;

@Validated
public interface RequestService {
	
	void register(@NotNull @Valid Request request) throws RequestAlreadyExistsException;
	
}
