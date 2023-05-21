package com.nuri.blog.handler;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value=IllegalArgumentException.class)
	public String handleArgumentException(IllegalArgumentException e) {
		return "<h1>" + e.getMessage() + "</h1>";
	}

	@ExceptionHandler(value=EmptyResultDataAccessException.class)
	public String handleArgumentException(EmptyResultDataAccessException e) {
		return "<h1>" + e.getMessage() + "</h1>";
	}
}
