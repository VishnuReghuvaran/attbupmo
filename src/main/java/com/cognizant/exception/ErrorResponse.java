package com.cognizant.exception;

public class ErrorResponse {
	/**
	 * errorCode
	 */
	 private int errorCode;
	 
	 /**
	  * message
	  */
	 private String message;

	 public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
