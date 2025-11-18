package xyz.blanchot.java_apirest_2026_fork.configuration.exception;

import org.springframework.http.HttpStatus;

public abstract class ApiException extends RuntimeException {

	public ApiException(String message) {
		super(message);
	}

	public abstract HttpStatus getHttpStatus();

}
