package com.mastercraft.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.mastercraft.dto.ResponseStructure;

@ControllerAdvice
public class ProductExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(NoSuchProductFoundException.class)
	public ResponseEntity<ResponseStructure<String>> catchNoSuchProductFoundException(NoSuchProductFoundException noSuchProductFoundException)
	{
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		responseStructure.setMessage("Product Not found");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(noSuchProductFoundException.getMessage());
		
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}
	
	
}
