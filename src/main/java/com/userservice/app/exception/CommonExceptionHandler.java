package com.userservice.app.exception;

import java.util.LinkedHashMap;
import java.util.Map;

//import javax.mail.MessagingException;
import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.userservice.app.constant.ExceptionConstant;
import com.userservice.app.constant.StatusConstant;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class CommonExceptionHandler extends ResponseEntityExceptionHandler {

	private static final Logger log = LoggerFactory.getLogger(CommonExceptionHandler.class);

	@ExceptionHandler(BadParameterException.class)
	protected ResponseEntity<Object> handleBadParameterException(BadParameterException ex) {
		log.error("BadParameterException");
		ErrorMessages error = new ErrorMessages(ex.getMessage(), "Bad Parameter. Please check request parameters",
				"FAILURE");
		return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(EntityNotFoundException.class)
	protected ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException ex) {
		log.error("EntityNotFoundException");
		ErrorMessages error = new ErrorMessages(ExceptionConstant.RECORD_NOT_FOUND_EC, "Details Not Found in Database",
				"FAILURE");
		return new ResponseEntity<Object>(error, HttpStatus.NOT_FOUND);
	}

//	@ExceptionHandler(MessagingException.class)
//	protected ResponseEntity<Object> handleMessagingException(MessagingException ex) {
//		log.error("MessagingException");
//		ErrorMessages error = new ErrorMessages(ex.getMessage(), "Message Body is Empty", "FAILURE");
//		return new ResponseEntity<Object>(error, HttpStatus.NOT_FOUND);
//	}
//
//	@ExceptionHandler(IOException.class)
//	protected ResponseEntity<Object> handleIOException(IOException ex) {
//		log.error("IOException");
//		ErrorMessages error = new ErrorMessages(ExceptionConstant.IO_EXC, ex.getMessage(), "FAILURE");
//		return new ResponseEntity<Object>(error, HttpStatus.NOT_FOUND);
//	}

	@ExceptionHandler(JobNotFoundException.class)
	protected ResponseEntity<Object> handleJobNotFoundException(JobNotFoundException ex) {
		log.error("JobNotFoundException");
		ErrorMessages error = new ErrorMessages(ExceptionConstant.JOB_NOT_FOUND_EC, ex.getMessage(), "FAILURE");
		return new ResponseEntity<Object>(error, HttpStatus.NOT_FOUND);
	}

//	@ExceptionHandler(FileUploadException.class)
//	protected ResponseEntity<Object> handleFileUploadException(FileUploadException ex) {
//		log.error("FileUploadException");
//		ErrorMessages error = new ErrorMessages(ExceptionConstant.FILE_UPLOAD_EX_EC, ex.getMessage(), "FAILURE");
//		return new ResponseEntity<Object>(error, HttpStatus.NOT_FOUND);
//	}


	@ExceptionHandler(NoDataFoundException.class)
	public ResponseEntity<Object> handleNoDataFoundException(NoDataFoundException ex, WebRequest request) {
		log.error("NoDataFoundException");
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("status", StatusConstant.STATUS_FAILURE);
		body.put("errorCode", ExceptionConstant.RECORD_NOT_FOUND_EC);
		body.put("errorMessage", ExceptionConstant.RECORD_NOT_FOUND_ED);

		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}
}
