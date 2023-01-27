package com.creditcard.exceptionhandler;

public class PinCodeNotFoundException extends RuntimeException {
	public PinCodeNotFoundException(String message) {
		super(message);
	}

}
