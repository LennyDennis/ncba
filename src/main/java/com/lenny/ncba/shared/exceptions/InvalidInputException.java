package com.lenny.ncba.shared.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidInputException extends RuntimeException {

    public InvalidInputException(String message) {
        super(message);
    }

    public InvalidInputException(String resourceName, String fieldName) {
        super(String.format("Invalid input for %s: %s ", resourceName, fieldName));
    }
}
