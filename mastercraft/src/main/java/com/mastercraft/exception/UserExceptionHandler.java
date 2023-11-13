package com.mastercraft.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mastercraft.dto.ResponseStructure;

@ControllerAdvice
public class UserExceptionHandler {

	@ExceptionHandler(NoSuchUserFoundException.class)
	public ResponseEntity<ResponseStructure<String>> catchNoSuchUserFoundException(NoSuchUserFoundException e) {
		ResponseStructure<String> rs = new ResponseStructure<String>(HttpStatus.NO_CONTENT.value(), "Success",
				e.getMessage());

		return new ResponseEntity<ResponseStructure<String>>(rs, HttpStatus.NO_CONTENT);
	}

	@ExceptionHandler(UserAlreadyExistException.class)
	public ResponseEntity<ResponseStructure<String>> catchUserAlreadyExistException(UserAlreadyExistException e) {
		ResponseStructure<String> rs = new ResponseStructure<String>(HttpStatus.CONFLICT.value(), e.getMessage(), null);
		return new ResponseEntity<ResponseStructure<String>>(rs, HttpStatus.CONFLICT);
	}
}
