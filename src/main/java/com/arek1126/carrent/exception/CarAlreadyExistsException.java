package com.arek1126.carrent.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class CarAlreadyExistsException extends RuntimeException{

    public CarAlreadyExistsException(){
        super("Car Already Exists");
    }
}
