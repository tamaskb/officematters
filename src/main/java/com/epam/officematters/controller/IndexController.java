package com.epam.officematters.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.epam.officematters.service.CommentService;
import com.epam.officematters.service.RequestService;

@Controller
public class IndexController {

	@Autowired
	private RequestService requestService;
	
	@Autowired
	private CommentService commentService;

	@RequestMapping("/")
	public String home(Model modelNew, Model modelInProgress, Model modelResolved) {
		modelNew.addAttribute("requestNew", requestService.getNewRequests());
		modelInProgress.addAttribute("requestInProgress", requestService.getInprogressRequests());
		modelResolved.addAttribute("requestResolved", requestService.getResolvedRequests());

		return "index";
	}
	
	@GetMapping("/requestdetails/{id}")
	public String getCommentForm(@PathVariable(value = "id") int id, Model model, Model commentModel) {

		model.addAttribute("request", requestService.getRequestById(id));
		commentModel.addAttribute("comment", commentService.getRequestComments(id));
		return "requestdetails";
	}

}
