package com.creditcard.exceptionhandler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class CustomeExceptionHadler {

	@ExceptionHandler(RuntimeException.class)
	public final ResponseEntity<ExceptionResponse> RuntimeExceptionHandler(Exception exception,WebRequest request){
		ExceptionResponse exceptionResponse=new ExceptionResponse(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(PinCodeNotFoundException.class)
	public final ResponseEntity<ExceptionResponse> PinCodeNotFoundExceptionHandler(Exception exception,WebRequest request){
		ExceptionResponse exceptionResponse=new ExceptionResponse(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
}
