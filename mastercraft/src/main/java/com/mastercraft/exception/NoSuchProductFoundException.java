package com.mastercraft.exception;

public class NoSuchProductFoundException extends RuntimeException {

	private String message;

	public NoSuchProductFoundException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}

}
