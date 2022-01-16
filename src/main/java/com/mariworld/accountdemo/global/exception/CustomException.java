package com.mariworld.accountdemo.global.exception;

import com.mariworld.accountdemo.common.CustomCode;
import lombok.Data;

@Data
public class CustomException extends RuntimeException{

    private CustomCode customCode;

    public CustomException(CustomCode customCode){
        this.customCode = customCode;
    }
}
