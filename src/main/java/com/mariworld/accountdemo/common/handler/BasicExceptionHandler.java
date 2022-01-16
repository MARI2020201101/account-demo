package com.mariworld.accountdemo.common.handler;

import com.mariworld.accountdemo.common.CustomCode;
import com.mariworld.accountdemo.common.CustomResponseEntity;
import com.mariworld.accountdemo.common.exception.CustomException;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class BasicExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public CustomResponseEntity globalException(Exception e){
        return new CustomResponseEntity(CustomCode.FAIL);
    }

    @ExceptionHandler(CustomException.class)
    public CustomResponseEntity customException(CustomException e){
        CustomCode customCode = e.getCustomCode();
        HttpHeaders  headers = new HttpHeaders();
        headers.set("Result-Code", customCode.getCode());
        headers.set("Result-Message", customCode.getUserMessage());
        return new CustomResponseEntity(headers, customCode);
    }
}
