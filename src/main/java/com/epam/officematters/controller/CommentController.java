package com.epam.officematters.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.epam.officematters.service.RequestService;



@Controller
public class CommentController {
	
	@Autowired
	private RequestService service;
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@GetMapping("/comment/{id}")
	public String comment(@PathVariable(value = "id") int id, Model model) {
		
		model.addAttribute("request", service.getRequestById(id));
		logger.info("request" + model);
				
		return "comment";
	}

}
