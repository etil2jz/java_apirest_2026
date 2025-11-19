package xyz.blanchot.java_apirest_2026_fork.configuration.exception.types;

import org.springframework.http.HttpStatus;
import xyz.blanchot.java_apirest_2026_fork.configuration.exception.ApiException;

public class BadRequestException extends ApiException {

	public BadRequestException(String message) {
		super(message);
	}

	@Override
	public HttpStatus getHttpStatus() {
		return HttpStatus.BAD_REQUEST;
	}

}
