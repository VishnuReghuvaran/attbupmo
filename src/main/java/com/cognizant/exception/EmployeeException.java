package com.cognizant.exception;

public class EmployeeException extends Exception {

	
	 private static final long serialVersionUID = 1L;
        
	/**
	 * errorMessage
	 */
	 private String message;
	 

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public EmployeeException(String message) {
		super();
		this.message = message;
	}
	
}
