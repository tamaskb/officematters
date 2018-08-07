package com.epam.officematters;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.epam.officematters.model.Request;
import com.epam.officematters.service.RequestService;
import com.epam.officematters.service.exception.RequestAlreadyExistsException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OfficeMattersApplicationTests {

	@Autowired
	private RequestService service;
	
	@Test
	public void test_registrationWithValidRequest() throws RequestAlreadyExistsException {
		service.register(new Request("john doe", "john@mail.com", "problem", "something isn't working"));
	}

}
