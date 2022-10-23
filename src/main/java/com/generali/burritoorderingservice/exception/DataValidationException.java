package com.generali.burritoorderingservice.exception;

import org.springframework.http.HttpStatus;


public class DataValidationException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private HttpStatus statusCode;
    
	public DataValidationException(String msg, HttpStatus statusCode) {
		super(msg);
		this.statusCode=statusCode;
	}
	public HttpStatus getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(HttpStatus statusCode) {
		this.statusCode = statusCode;
	}


}
