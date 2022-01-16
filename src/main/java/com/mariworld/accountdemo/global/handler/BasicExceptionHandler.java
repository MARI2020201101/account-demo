package com.mariworld.accountdemo.global.handler;

import com.mariworld.accountdemo.common.CustomCode;
import com.mariworld.accountdemo.common.CustomResponseEntity;
import com.mariworld.accountdemo.global.exception.CustomException;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@RestController
@ControllerAdvice
public class BasicExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public CustomResponseEntity<String> globalException(Exception e){
        return new CustomResponseEntity<>(e.getMessage(), CustomCode.FAIL);
    }

    @ExceptionHandler(CustomException.class)
    public CustomResponseEntity<String> customException(CustomException e){
        CustomCode customCode = e.getCustomCode();
        String resultMessage = customCode.getUserMessage();

        HttpHeaders  headers = new HttpHeaders();
        headers.set("Result-Code", customCode.getCode());
        headers.set("Result-Message", Base64.getEncoder().encodeToString(resultMessage.getBytes(StandardCharsets.UTF_8)));
        return new CustomResponseEntity<>(resultMessage, headers, customCode);
    }
}
