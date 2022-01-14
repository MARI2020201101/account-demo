package com.mariworld.accountdemo.common.advice;

import com.mariworld.accountdemo.common.CustomCode;
import com.mariworld.accountdemo.common.exception.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class BasicExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity globalException(Exception e){
        return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<CustomCode> customException(CustomException e){
        return new ResponseEntity(e.getCustomCode(), HttpStatus.BAD_REQUEST);
    }
}
