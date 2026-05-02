package com.example.demo1.controllers;


import com.example.demo1.exception.ExceptionResponse;
import com.example.demo1.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class ExceptionHandling {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleInternalException(ResourceNotFoundException ex) {
        log.error(ex.getMessage());
        return new ResponseEntity<>(ExceptionResponse.of(404, ex.getMessage()), HttpStatus.NOT_FOUND);
    }
}