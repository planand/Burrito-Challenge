package com.generali.burritoorderingservice.exception;

import org.springframework.http.HttpStatus;

public class ErrorModel {
	
	private HttpStatus status;
	private String message;


	public ErrorModel(HttpStatus status, String message) {
		super();
		this.status = status;
		this.message = message;
		
	}


	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


}
