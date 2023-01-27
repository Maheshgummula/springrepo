package com.example.demo.exceptionhandler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(StudentAlreadyExists.class)
	public final ResponseEntity<ExceptionResponse> handlerStudentAlreadyExists(Exception exception,WebRequest request) throws Exception{
		ExceptionResponse exceptionResponse=new ExceptionResponse(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(RuntimeException.class)
	public final ResponseEntity<ExceptionResponse> handlerRuntimeException(Exception exception,WebRequest request) throws Exception{
		ExceptionResponse exceptionResponse=new ExceptionResponse(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> handlerException(Exception exception,WebRequest request) throws Exception{
		ExceptionResponse exceptionResponse=new ExceptionResponse(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
	
	

}
