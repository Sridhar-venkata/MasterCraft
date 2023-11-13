package com.mastercraft.exception;

public class NoSuchOrderFoundException extends RuntimeException {
	private String message;

	public NoSuchOrderFoundException(String message) {
		super(message);
	}
}
