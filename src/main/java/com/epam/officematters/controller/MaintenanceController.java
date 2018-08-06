package com.epam.officematters.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MaintenanceController {
	
	@RequestMapping("/maintenance")
	public String maintenance() {
		return "maintenance";
	}

}
