package com.mastercraft.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.mastercraft.dto.ResponseStructure;

@ControllerAdvice
public class ReviewExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(NoSuchReviewFoundException.class)
	public ResponseEntity<ResponseStructure<String>> catchNosuchReviewFoundException(NoSuchReviewFoundException nosuchReviewFoundException)
	{
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		responseStructure.setMessage("Review Id Not Found");
		responseStructure.setStatusCode(HttpStatus.NO_CONTENT.value());
		responseStructure.setData(nosuchReviewFoundException.getMessage());
		
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NO_CONTENT);
	}
}
