package com.mastercraft.exception;

public class NoSuchProductFoundException extends RuntimeException{
	
	String message;

	public NoSuchProductFoundException(String message) {
		super();
		this.message = message;
	}
	@Override
	public String getMessage() {
		return message;
	}
}
