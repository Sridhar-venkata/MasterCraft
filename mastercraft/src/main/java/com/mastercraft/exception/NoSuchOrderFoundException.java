package com.mastercraft.exception;

public class NoSuchOrderFoundException extends RuntimeException {
	private String message;

	public NoSuchOrderFoundException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}
}
