package com.epam.officematters.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class ConfirmationController {
	
	@RequestMapping("/confirmation")
	public String confirmation() {
		return "confirmation";
	}

}
