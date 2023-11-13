package com.mastercraft.exception;

public class NosuchReviewFoundException extends RuntimeException {
	
	String message;

	public NosuchReviewFoundException(String message) {
		super();
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}
