package com.letocart.java_apirest_2026.configuration.exception;

import org.springframework.http.HttpStatus;

public abstract class ApiException extends RuntimeException {

	public ApiException(String message) {
		super(message);
	}

	public abstract HttpStatus getHttpStatus();

}
