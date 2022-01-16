package com.mariworld.accountdemo.common;

import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

public class CustomResponseEntity<T> extends ResponseEntity<T> {

    private CustomCode customCode;


    public CustomResponseEntity(CustomCode customCode){
        super(customCode.getHttpStatus());
        this.customCode = customCode;
    }

    public CustomResponseEntity(MultiValueMap<String, String> headers, CustomCode customCode){
        super(headers, customCode.getHttpStatus());
        this.customCode = customCode;

    }

    public CustomResponseEntity(T body, CustomCode customCode){
        super(body, customCode.getHttpStatus());
        this.customCode = customCode;
    }

    public CustomResponseEntity(T body, MultiValueMap<String, String> headers, CustomCode customCode) {
        super(body, headers, customCode.getHttpStatus());
        this.customCode= customCode;
    }
}
