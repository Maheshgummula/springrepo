package com.buykart.exceptionhandler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(CategoryException.class)
	public final ResponseEntity<ExceptionResponse> CategoryExceptionHandler(Exception exception, WebRequest request)
			throws Exception {
		ExceptionResponse response = new ExceptionResponse(new Date(), exception.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(RuntimeException.class)
	public final ResponseEntity<ExceptionResponse> RuntimeExceptionHandler(Exception exception, WebRequest request)
			throws Exception {
		ExceptionResponse response = new ExceptionResponse(new Date(), exception.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> handlerException(Exception exception, WebRequest request)
			throws Exception {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), exception.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
}
