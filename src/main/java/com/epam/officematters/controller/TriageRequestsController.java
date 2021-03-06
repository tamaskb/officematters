package com.epam.officematters.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.epam.officematters.model.Request;
import com.epam.officematters.service.RequestService;



@Controller
public class TriageRequestsController {
	

	@Autowired
	private RequestService service;
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@GetMapping("/triagerequest/{id}")
	public String triagerequest(@PathVariable(value = "id") int id, Model model) {
		
		model.addAttribute("request", service.getRequestById(id));
		logger.info("request" + model);
				
		return "triagerequest";
	}
	
	@GetMapping("/maintenance/triage")
	public String triage(Model model) {
		model.addAttribute("request", service.getNotTriagedRequests());
		return "triage";
	}
		
	@PostMapping("/triageconfirm/{id}")
	public String submitPriority(@PathVariable(value = "id") int id, @ModelAttribute Request request) {
		service.changeRequestPriority(request, id);
		return "redirect:/maintenance/triage";
	}

}
