package com.letocart.java_apirest_2026.configuration.exeption.types;

import com.letocart.java_apirest_2026.configuration.exeption.ApiException;
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
