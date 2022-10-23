package com.poc.dataService.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(DataValidationException.class)
	public ResponseEntity<Object> handleBusinessValidation(DataValidationException ex) {

		ErrorModel apiError = new ErrorModel(ex.getStatusCode(), ex.getMessage());

		return new ResponseEntity<>(apiError,ex.getStatusCode());
	}

}
