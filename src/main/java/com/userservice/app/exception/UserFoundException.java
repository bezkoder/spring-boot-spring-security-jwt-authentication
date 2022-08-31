package com.userservice.app.exception;

public class UserFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private String message = "This username is already registered. Try with another username !!!";
	private String errorCode = "";
	
	public UserFoundException() {
		
	}

	public UserFoundException(String message, String errorCode) {
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
		return "UserFoundException [message=" + message + "]";
	}
	
	
}
