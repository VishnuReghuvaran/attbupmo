package com.cognizant.exception;

public class ProjectException extends Exception {

	
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

	public ProjectException(String message) {
		super();
		this.message = message;
	}
	
}
