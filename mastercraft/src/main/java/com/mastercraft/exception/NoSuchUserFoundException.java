package com.mastercraft.exception;

public class NoSuchUserFoundException extends RuntimeException {

	private String message;

	public NoSuchUserFoundException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}

}
