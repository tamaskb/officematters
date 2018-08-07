package com.epam.officematters;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.epam.officematters.service.RequestService;

@SpringBootApplication
public class OfficeMattersApplication implements CommandLineRunner{

	private RequestService service;
	
	public static void main(String[] args) {
		SpringApplication.run(OfficeMattersApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}
	

}
