package com.microservice.exception;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequestMapping("/")
public class GlobalExceptionHandler {

	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(value = { UserAlreadyExistsException.class, UserNotFoundException.class })
	public ErrorResponse handleNotFound(Exception ex, HttpServletRequest req) {
		return new ErrorResponse(ex.getMessage(), req.getRequestURI(), LocalDateTime.now().toString());
	}

	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = { Exception.class })
	public ErrorResponse handleError(Exception ex, HttpServletRequest req) {
		return new ErrorResponse(ex.getMessage(), req.getRequestURI(), LocalDateTime.now().toString());
	}
}
