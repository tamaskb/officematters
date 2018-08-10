package com.epam.officematters.repository;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.epam.officematters.model.Request;

@Validated
public interface RequestRepository {
	
	void save (@NotNull @Valid Request request);
	
	Request findRequestById(int id);
	
	List<Request> listNewRequests();
	
	List<Request> listInProgressRequests();
	
	List<Request> listResolvedRequests();
	
	List<Request> listNotTriagedRequests();
	
	void pushRequestToInProgress(Request request, int id);
	
	void setRequestPriority(Request request, int id);
	
}
