package com.epam.officematters.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.epam.officematters.model.Comment;
import com.epam.officematters.model.Request;
import com.epam.officematters.service.CommentService;
import com.epam.officematters.service.RequestService;

@Controller
public class MaintenanceController {
	
	@Autowired
	private RequestService service;
	
	@Autowired
	private CommentService commentService;
	
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
	public String updateRequests(@PathVariable(value = "id") int id, Model model, Model commentModel, @ModelAttribute ("commentForm") Comment c) {
		model.addAttribute("request", service.getRequestById(id));
		commentModel.addAttribute("comment", commentService.getRequestComments(id));
		return "updaterequests";
	}
	
	@PostMapping("/comment/{id}")
	public String sendComment(@PathVariable(value = "id") int id,
			@Valid @ModelAttribute("commentForm") Comment comment, Model model, Model commentModel,
			BindingResult result) {
		model.addAttribute("request", service.getRequestById(id));
		commentModel.addAttribute("comment", commentService.getRequestComments(id));
		if (result.hasErrors()) {
			result.reject("commentForm.error.incompleteInput");
			return "/maintenance/requests/{id}";
		} else {
			commentService.registerComment(comment, id);
			return "redirect:/maintenance";
		}
	}
	
	@GetMapping("/maintenance/requests/startprogress/{id}")
	public String startRequestProgress(@PathVariable(value = "id") int id, @ModelAttribute Request request) {
		service.changeRequestToInProgress(request, id);
		return "redirect:/maintenance";
	}

}
