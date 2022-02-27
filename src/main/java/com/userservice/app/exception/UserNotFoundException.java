package com.userservice.app.exception;

public class UserNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private String message = "User with this username not found  !!!";
	private String errorCode = "";
	
	public UserNotFoundException() {
		
	}

	public UserNotFoundException(String message, String errorCode) {
//		super();
		this.message = message;
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	@Override
	public String toString() {
		return "UserNotFoundException [message=" + message + "]";
	}
	
	
}
