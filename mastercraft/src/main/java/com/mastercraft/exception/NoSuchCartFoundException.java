package com.mastercraft.exception;

public class NoSuchCartFoundException extends RuntimeException {

	private String message;

	public NoSuchCartFoundException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}
}
