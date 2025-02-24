package com.kevingeo.api.db_shopping.controller;

import com.kevingeo.api.db_shopping.exception.BussinesException;
import com.kevingeo.api.db_shopping.exception.NotFoundExceptionApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHendlingController {


    @ExceptionHandler(value = {BussinesException.class})
    public ResponseEntity<String> customException(BussinesException ex) {
        return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {NotFoundExceptionApi.class})
    public ResponseEntity<String> customException(NotFoundExceptionApi ex) {
        return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<String> customException(Exception ex) {
        return new ResponseEntity<String>("An error occurred while processing the request", HttpStatus.BAD_REQUEST);
    }
}
