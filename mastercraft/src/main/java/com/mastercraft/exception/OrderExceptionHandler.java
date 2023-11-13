package com.mastercraft.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mastercraft.dto.ResponseStructure;

@ControllerAdvice
public class OrderExceptionHandler {

	@ExceptionHandler(NoSuchOrderFoundException.class)
	public ResponseEntity<ResponseStructure<String>> catchNoSuchOrderFoundException(NoSuchOrderFoundException e) {
		ResponseStructure<String> rs = new ResponseStructure<String>(HttpStatus.NO_CONTENT.value(), "Success",
				e.getMessage());

		return new ResponseEntity<ResponseStructure<String>>(rs, HttpStatus.NO_CONTENT);
	}
}
