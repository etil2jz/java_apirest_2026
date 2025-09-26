package com.letocart.java_apirest_2026.configuration.exeption;


import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;


@AllArgsConstructor
@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessageError {

    private final String message;
    private Map<String, String> errors;
}
