package com.cognizant.exception;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cognizant.exception.ErrorResponse;

@ControllerAdvice
@RequestMapping(produces = "application/json")
public class ExceptionControllerAdvice {
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<Object> exceptionHandler(RuntimeException ex) {
		ErrorResponse error = new ErrorResponse();
		error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setMessage("Internal Server Error :"+ex.getMessage());		
		return new ResponseEntity<Object>(error, HttpStatus.OK);
	} 
}
