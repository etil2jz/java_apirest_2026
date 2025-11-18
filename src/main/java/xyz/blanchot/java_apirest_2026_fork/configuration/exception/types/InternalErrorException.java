package xyz.blanchot.java_apirest_2026_fork.configuration.exception.types;

import xyz.blanchot.java_apirest_2026_fork.configuration.exception.ApiException;
import org.springframework.http.HttpStatus;

public class InternalErrorException extends ApiException {

	public InternalErrorException() {
		this("Internal error");
	}

	public InternalErrorException(String message) {
		super(message);
	}

	@Override
	public HttpStatus getHttpStatus() {
		return HttpStatus.INTERNAL_SERVER_ERROR;
	}

}
