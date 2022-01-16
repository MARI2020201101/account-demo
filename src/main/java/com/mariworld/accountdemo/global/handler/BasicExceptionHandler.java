package com.mariworld.accountdemo.global.handler;

import com.mariworld.accountdemo.common.CustomCode;
import com.mariworld.accountdemo.common.CustomResponseEntity;
import com.mariworld.accountdemo.global.exception.CustomException;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;

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
        headers.set("Result-Message", Base64.getEncoder().encodeToString(customCode.getUserMessage().getBytes()));
        return new CustomResponseEntity(headers, customCode);
    }
}
