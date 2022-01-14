package com.mariworld.accountdemo.common.exception;

import com.mariworld.accountdemo.common.CustomCode;
import lombok.Data;

@Data
public class CustomException extends RuntimeException{

    private String message;
    private CustomCode customCode;

    public CustomException(String message){
        super(message);
        this.message = message;
    }
    public CustomException(CustomCode customCode){
        this.customCode = customCode;
    }
}
