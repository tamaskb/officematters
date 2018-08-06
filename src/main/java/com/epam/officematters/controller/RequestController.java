package com.epam.officematters.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.epam.officematters.model.Request;

@Controller
public class RequestController {
	
	@GetMapping("/request")
	public String getRequestForm (Model model) {
		model.addAttribute("request", new Request());
		return "request";
	}
	
	@PostMapping
	public String submitRequestForm (Request request) {
		return "request";
	}
	

}
