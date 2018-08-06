package com.epam.officematters.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConfirmationController {
	
	@RequestMapping("/confirmation")
	public String confirmation() {
		return "confirmation";
	}

}
