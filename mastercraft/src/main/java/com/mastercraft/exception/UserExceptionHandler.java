package com.mastercraft.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.mastercraft.dto.ResponseStructure;

@ControllerAdvice
public class UserExceptionHandler  extends ResponseEntityExceptionHandler {

	@ExceptionHandler(NoSuchUserFoundExcetion.class)
	public ResponseEntity<ResponseStructure<String>> UserNoSuchUserFoundExcetion(NoSuchUserFoundExcetion noSuchUserFoundExcetion){
		
		ResponseStructure<String> responseStructure=new ResponseStructure<String>(HttpStatus.NOT_FOUND.value(),"Not Found",noSuchUserFoundExcetion.getMessage());
		
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(UserAlreadyExistException.class)
	public ResponseEntity<ResponseStructure<String>> catchUserAlreadyExistException(UserAlreadyExistException userAlreadyExistException) {
		
		ResponseStructure<String> rs = new ResponseStructure<String>(HttpStatus.CONFLICT.value(), "Not Found",userAlreadyExistException.getMessage());
		
		return new ResponseEntity<ResponseStructure<String>>(rs, HttpStatus.CONFLICT);

	}
}
