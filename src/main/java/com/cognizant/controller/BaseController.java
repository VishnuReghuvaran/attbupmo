/**
 * 
 */
package com.cognizant.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cognizant.exception.EmployeeException;
import com.cognizant.exception.ErrorResponse;
import com.cognizant.exception.ExceptionControllerAdvice;
import com.cognizant.exception.ProjectException;

/**
 * @author 407807
 *
 */
public class BaseController extends ExceptionControllerAdvice {

	
    @ExceptionHandler(EmployeeException.class)
    public ResponseEntity<Object> exceptionHandler(Exception ex) {
        ErrorResponse error = new ErrorResponse();	
        error.setErrorCode(HttpStatus.NOT_FOUND.value());	
        error.setMessage(ex.getMessage());	
        return new ResponseEntity<Object>(error, HttpStatus.OK);

    }
    
    @ExceptionHandler(ProjectException.class)
    public ResponseEntity<Object> projectSearchExceptionHandler(Exception ex) {
        ErrorResponse error = new ErrorResponse();	
        error.setErrorCode(HttpStatus.NOT_FOUND.value());	
        error.setMessage(ex.getMessage());	
        return new ResponseEntity<Object>(error, HttpStatus.OK);

    }
}
