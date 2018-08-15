package com.epam.officematters.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.epam.officematters.model.Request;
import com.epam.officematters.service.RequestService;

@Controller
public class MaintenanceController {
	
	@Autowired
	private RequestService service;
	
	@GetMapping("/maintenance")
	public String maintenance(Model modelNew, Model modelInProgress, Model modelResolved) {
		modelNew.addAttribute("requestNew", service.getNewRequests());
		modelInProgress.addAttribute("requestInProgress", service.getInprogressRequests());
		modelResolved.addAttribute("requestResolved", service.getResolvedRequests());
		return "maintenance";
	}
	
	@GetMapping("/maintenance/triage")
	public String triage(Model model) {
		model.addAttribute("request", service.getNotTriagedRequests());
		return "triage";
	}
	
	@GetMapping("/maintenance/requests/{id}")
	public String updateRequests(@PathVariable(value = "id") int id, Model model) {
		model.addAttribute("request", service.getRequestById(id));
		return "updaterequests";
	}
	
	@GetMapping("/maintenance/requests/startprogress/{id}")
	public String startRequestProgress(@PathVariable(value = "id") int id, @ModelAttribute Request request) {
		service.changeRequestToInProgress(request, id);
		return "redirect:/maintenance";
	}

}
