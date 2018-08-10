package com.epam.officematters.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.epam.officematters.service.RequestService;

@Controller
public class IndexController {

	@Autowired
	private RequestService requestService;

	@RequestMapping("/")
	public String home(Model modelNew, Model modelInProgress, Model modelResolved) {
		modelNew.addAttribute("requestNew", requestService.getNewRequests());
		modelInProgress.addAttribute("requestInProgress", requestService.getInprogressRequests());
		modelResolved.addAttribute("requestResolved", requestService.getResolvedRequests());

		return "index";
	}

}
