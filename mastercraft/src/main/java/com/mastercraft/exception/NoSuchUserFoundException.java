package com.mastercraft.exception;

public class NoSuchUserFoundException extends RuntimeException{
	
	String message;

	public NoSuchUserFoundException(String message) {
		super();
		this.message = message;
	}
	@Override
	public String getMessage() {
		return message;
	}
}
