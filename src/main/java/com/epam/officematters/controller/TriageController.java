package com.epam.officematters.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.epam.officematters.service.RequestService;

@Controller
public class TriageController {
	
	@Autowired
	private RequestService service;
	
	@GetMapping("/triage")
	public String triage(Model model) {
		model.addAttribute("request", service.getNotTriagedRequests());
				
		return "triage";
	}

}
