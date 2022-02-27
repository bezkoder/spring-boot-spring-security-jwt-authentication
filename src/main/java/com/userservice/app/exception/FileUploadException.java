package com.userservice.app.exception;

/**
 * @author Narendra Gangwar
 * FileUploadException.java
 * Sep 10, 2019
 */
public class FileUploadException extends RuntimeException{
	
	
	private static final long serialVersionUID = 1L;
	
	private String message="FileUploadException Occured";
	private String errorCode="";

	public FileUploadException() {
		
	}
	public FileUploadException(String message) {
//		this.errorCode=errorCode;
		this.message = message;
	}
	
	public FileUploadException(String errorCode,String message) {
		this.errorCode=errorCode;
		this.message = message;
	}
	
	
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "FileUploadException [message=" + message + "]";
	}
	
	

}
