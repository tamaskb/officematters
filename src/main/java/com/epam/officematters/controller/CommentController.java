package com.epam.officematters.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.epam.officematters.model.Comment;
import com.epam.officematters.model.Request;
import com.epam.officematters.service.CommentService;
import com.epam.officematters.service.RequestService;



@Controller
public class CommentController {
	
	private static final String COMMENT_FORM = "comment";

	private static final String COMMENT_FORM_ATTRIBUTE = "commentForm";

	private static final String PATH_COMMENT_ID = "/comment/{id}";

	@Autowired
	private RequestService service;
	
	@Autowired
	private CommentService commentService;
	
	
	@GetMapping(PATH_COMMENT_ID)
	public String getCommentForm(@PathVariable(value = "id") int id,@ModelAttribute(COMMENT_FORM_ATTRIBUTE) Comment c, Model model) {
		
		model.addAttribute("request", service.getRequestById(id));
				
		return COMMENT_FORM;
	}
	
	@PostMapping(PATH_COMMENT_ID)
	public String sendComment(@PathVariable(value = "id") int id, @ModelAttribute(COMMENT_FORM_ATTRIBUTE) Comment comment, Model model) {
		model.addAttribute("request", service.getRequestById(id));
		commentService.registerComment(comment, id);
		
		return COMMENT_FORM;
	}

}
