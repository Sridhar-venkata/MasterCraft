package com.mastercraft.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mastercraft.dto.ResponseStructure;

@ControllerAdvice
public class AddressExceptionHandler {
	
	@ExceptionHandler(NoSuchAddressFoundException.class)
	public ResponseEntity<ResponseStructure<String>> addressNoSuchAddressFound(NoSuchAddressFoundException noSuchAddressFound){
		
		ResponseStructure<String> responseStructure=new ResponseStructure<String>(HttpStatus.NOT_FOUND.value(),"Not Found",noSuchAddressFound.getMessage());
		
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}
}
