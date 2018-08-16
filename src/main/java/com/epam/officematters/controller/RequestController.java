package com.epam.officematters.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.epam.officematters.model.Request;
import com.epam.officematters.service.RequestService;
import com.epam.officematters.service.exception.RequestAlreadyExistsException;

@Controller
public class RequestController {

	private static final String REQUEST_FORM = "request";
	private static final String REQUEST_FORM_ATTRIBUTE = "requestForm";
	private static final String PATH_REQUEST = "/request";

	@Autowired
	private RequestService requestService;

	@GetMapping(PATH_REQUEST)
	public String getRequestForm(@ModelAttribute(REQUEST_FORM_ATTRIBUTE) Request r) {
		return REQUEST_FORM;
	}

	@PostMapping(PATH_REQUEST)
	public String submitRequest(@Valid @ModelAttribute(REQUEST_FORM_ATTRIBUTE) Request request, BindingResult result,
			HttpServletResponse response) throws RequestAlreadyExistsException {
		if (result.hasErrors()) {
			response.setStatus(HttpStatus.BAD_REQUEST.value());
			result.reject("requestForm.error.incompleteInput");
			return REQUEST_FORM;
		}
		requestService.register(request);
		return "redirect:/confirmation";
	}

}
