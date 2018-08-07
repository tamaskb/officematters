package com.epam.officematters.repository;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.epam.officematters.model.Request;

@Validated
public interface RequestRepository {
	
	void save (@NotNull @Valid Request request);

}
