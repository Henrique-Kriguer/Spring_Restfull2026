package com.github.henriquekriguer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RequiredObjectIsNullException extends RuntimeException {

    public RequiredObjectIsNullException() {
        super("Is Not allowed to persist a null object!");
    }


    public RequiredObjectIsNullException(String message) {
        super(message);
    }
}
