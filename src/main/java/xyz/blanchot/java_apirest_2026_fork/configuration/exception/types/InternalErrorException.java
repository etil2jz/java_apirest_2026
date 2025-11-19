package xyz.blanchot.java_apirest_2026_fork.configuration.exception.types;

import org.springframework.http.HttpStatus;
import xyz.blanchot.java_apirest_2026_fork.configuration.exception.ApiException;

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
