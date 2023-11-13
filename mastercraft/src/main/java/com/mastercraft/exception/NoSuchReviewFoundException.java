package com.mastercraft.exception;

public class NoSuchReviewFoundException extends RuntimeException {
	
	String message;

	public NoSuchReviewFoundException(String message) {
		super();
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}
