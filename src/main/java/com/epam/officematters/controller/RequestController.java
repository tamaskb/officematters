package com.epam.officematters.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.epam.officematters.model.Request;
import com.epam.officematters.service.RequestService;

@Controller
public class RequestController {
	
	private static final String REQUEST_FORM = "request";
	private static final String REQUEST_FORM_ATTRIBUTE = "requestForm";
	private static final String PATH_REQUEST = "/request";
	
	@Autowired
	private RequestService requestService;

	@GetMapping(PATH_REQUEST)
	public String getRequestForm (@ModelAttribute (REQUEST_FORM_ATTRIBUTE) Request r) {
		return REQUEST_FORM;
	}
		
	@PostMapping(PATH_REQUEST)
	public String submitRequest (@Valid @ModelAttribute (REQUEST_FORM_ATTRIBUTE) Request request, BindingResult result) {
		if (result.hasErrors()) {
			return REQUEST_FORM;
		} else {
			requestService.register(request);			
			return "redirect:/confirmation";
		}
	}
	
	
	

}
