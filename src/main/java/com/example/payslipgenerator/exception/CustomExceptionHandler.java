package com.example.payslipgenerator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<List<String>> dtoValidationException(ConstraintViolationException exception){

        List<String> errors = new ArrayList<>();
        exception
                .getConstraintViolations()
                .stream()
                .forEach(error -> errors.add(error.getMessage()));
        exception.getMessage();

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
