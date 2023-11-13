package com.mastercraft.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.mastercraft.dto.ResponseStructure;

@ControllerAdvice
public class CartExceptionHandler  extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(NoSuchCartFoundException.class)
	public ResponseEntity<ResponseStructure<String>> catchNoSuchUserFoundException(NoSuchCartFoundException noSuchCartFoundException)
	{
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		responseStructure.setMessage("Cart Not Found");
		responseStructure.setStatusCode(HttpStatus.NO_CONTENT.value());
		responseStructure.setData(noSuchCartFoundException.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NO_CONTENT);
	}
}
