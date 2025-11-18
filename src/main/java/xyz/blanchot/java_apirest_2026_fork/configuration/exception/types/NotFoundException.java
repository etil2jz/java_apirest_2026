package xyz.blanchot.java_apirest_2026_fork.configuration.exception.types;

import xyz.blanchot.java_apirest_2026_fork.configuration.exception.ApiException;
import org.springframework.http.HttpStatus;


public class NotFoundException extends ApiException {

	public NotFoundException() {
		this("Not found");
	}

	public NotFoundException(String message) {
		super(message);
	}

	@Override
	public HttpStatus getHttpStatus() {
		return HttpStatus.NOT_FOUND;
	}

}
