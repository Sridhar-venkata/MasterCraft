package com.mastercraft.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.mastercraft.dto.ResponseStructure;

@ControllerAdvice
public class UserExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(NoSuchUserFoundException.class)
	public ResponseEntity<ResponseStructure<String>> catchNoSuchUserFoundException(
			NoSuchUserFoundException noSuchUserFoundException) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setMessage("User Not Found");
		responseStructure.setStatusCode(HttpStatus.NO_CONTENT.value());
		responseStructure.setData(noSuchUserFoundException.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NO_CONTENT);
	}
	
	@ExceptionHandler(UserAlreadyExistException.class)
	public ResponseEntity<ResponseStructure<String>> catchUserAlreadyExistException(UserAlreadyExistException e) {
		ResponseStructure<String> rs = new ResponseStructure<String>(HttpStatus.CONFLICT.value(), "FAILED",
				e.getMessage());

		return new ResponseEntity<ResponseStructure<String>>(rs, HttpStatus.CONFLICT);

	}
}
