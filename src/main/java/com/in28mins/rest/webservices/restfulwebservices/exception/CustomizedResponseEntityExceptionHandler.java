package com.in28mins.rest.webservices.restfulwebservices.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;

public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleExcepting(Exception ex, WebRequest request){
            ErrorDetails errorDetails = new ErrorDetails(LocalDate.now(), ex.getMessage(), request.getDescription(false));
    }
}
