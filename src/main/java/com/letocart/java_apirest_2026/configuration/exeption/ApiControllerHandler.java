package com.letocart.java_apirest_2026.configuration.exeption;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiControllerHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<MessageError> handleApiException(ApiException ex) {
        MessageError message = MessageError.builder().message(ex.getMessage()).build();
        return new ResponseEntity<>(message, ex.getHttpStatus());
    }

}
