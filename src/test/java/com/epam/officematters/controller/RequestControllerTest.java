package com.epam.officematters.controller;

import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;

import java.util.Locale;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.epam.officematters.model.Request;
import com.epam.officematters.service.exception.RequestAlreadyExistsException;

@RunWith(SpringRunner.class)
@WebMvcTest(RequestController.class)
public class RequestControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	private ResultActions result;
	
	private void given_theUserIsOnTheRequestPage() throws Exception{
		
		result = mvc.perform(
				get("/request")
				.accept(MediaType.TEXT_HTML)
				.locale(Locale.ENGLISH))
				
				.andDo(print())
				.andExpect(content().contentType("text/html;charset=UTF-8"))
				.andExpect(status().isOk())
				.andExpect(view().name("requestForm"));
		
	}
	
	private void then_theFormContains(final Request request) throws Exception {
		
		result.andExpect(xpath("//input[@name='" + "fullName" + "']/@value").string(request.getFullName()))
			  .andExpect(xpath("//input[@name='" + "emailAddress" + "']/@value").string(request.getEmailAddress()))
			  .andExpect(xpath("//input[@name='" + "fullName" + "']/@value").string(request.getSubject()))
			  .andExpect(xpath("//input[@name='" + "fullName" + "']/@value").string(request.getDescription()));
	}
	
	@Test
	public void testRequestFormIsEmptyWhenRequestFormIsOpened() throws Exception {
		given_theUserIsOnTheRequestPage();
		then_theFormContains(new Request("", "", "", ""));
	}
	
	/* 
	 * Duplicated request checking	
	 */
	
/*	private void then_theUserSeesThatTheRequestIsAlreadyRegistered() {
		
	}

	private void then_requestIsSentToTheService(Request duplicateRequest) {
		// TODO Auto-generated method stub
		
	}

	private void when_userSubmitsRequestFormContaining(Request duplicateRequest) {
		// TODO Auto-generated method stub
		
	}

	private void given_aRequestAlreadyExists(String alreadyExistingRequest) 
		throws RequestAlreadyExistsException {
		doThrow(new RequestAlreadyExistsException(null))
			.when(requestService)
			.register(argThat(request -> request.equals(alreadyExistingRequest)));
		
	}
	
	@Test
	public void testRequestRefusedDueToDuplication() throws Exception {
		final Request duplicateRequest = new Request("john doe", "john@mail.com", "problem", "something went wrong");
		given_theUserIsOnTheRequestPage();
		given_aRequestAlreadyExists(duplicateRequest);
		when_userSubmitsRequestFormContaining(duplicateRequest);
		then_requestIsSentToTheService(duplicateRequest);
		then_theUserSeesThatTheRequestIsAlreadyRegistered();
	}
*/

}
