package com.userservice.app.exception;

public class ErrorMessages {

	private String errorCode;
	private String errorMsg;
	
	private String status;

	public ErrorMessages(String errorCode, String errorMsg, String status) {
		super();
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
		this.status = status;
	}

	public ErrorMessages() {
		super();
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	

}
