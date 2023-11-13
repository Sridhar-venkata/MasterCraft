package com.mastercraft.exception;

public class NoSuchCartFoundException extends RuntimeException{
	
	String message;

	public NoSuchCartFoundException(String message) {
		super();
		this.message = message;
	}
	@Override
	public String getMessage() {
		return message;
	}
}
