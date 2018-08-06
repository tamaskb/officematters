package com.epam.officematters.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	public String submitRequestForm (@Valid @ModelAttribute Request request, BindingResult result) {
		if (result.hasErrors()) {
			return "redirect:request";
		} else {
			return "confirmation";
		}
	}
	

}
