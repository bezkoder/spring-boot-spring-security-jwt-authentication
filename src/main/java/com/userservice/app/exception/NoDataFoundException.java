package com.userservice.app.exception;

public class NoDataFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NoDataFoundException(String msg) {

		super(msg);
	}

}