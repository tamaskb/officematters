package com.epam.officematters;

import javax.validation.ConstraintViolationException;

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
public class RequestValidationTests {

	@Autowired
	private RequestService service;
	
	@Test(expected = ConstraintViolationException.class)
	public void test_registrationWithNullRequest_fails() throws RequestAlreadyExistsException {
		service.register(null);
	}
	
	@Test(expected = ConstraintViolationException.class)
	public void test_registrationWithNameOfSpaceOnly_fails() throws RequestAlreadyExistsException {
		service.register(new Request("   ", "john@mail.com", "problem", "something isn't working"));
	}
	
	@Test(expected = ConstraintViolationException.class)
	public void test_registrationWithInvalidEmailAddressFormat_fails() throws RequestAlreadyExistsException {
		service.register(new Request("john doe", "john", "problem", "something isn't working"));
	}
	

}
