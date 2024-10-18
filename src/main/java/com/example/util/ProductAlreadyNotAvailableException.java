package com.example.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ProductAlreadyNotAvailableException extends RuntimeException{

    public ProductAlreadyNotAvailableException(String message) {
        super(message);
    }
}
