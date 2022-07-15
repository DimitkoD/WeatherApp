package com.example.springbootproject.data.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class LocationNotFoundException extends RuntimeException {
    public LocationNotFoundException() {
        super("The location is not found!!!");
    }
}
