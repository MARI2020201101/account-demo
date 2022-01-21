package com.mariworld.accountdemo.common;

import org.springframework.http.HttpStatus;

public enum CustomCode {
    SUCCESS("0000","성공",HttpStatus.OK),
    ALREADY_EXIST_USER("0001","이미 존재하는 회원입니다.", HttpStatus.BAD_REQUEST),
    NON_EXIST_USER("0002","존재하지 않는 회원입니다.", HttpStatus.BAD_REQUEST),
    NON_MATCH_PASSWORD("0003","비밀번호가 일치하지 않습니다." , HttpStatus.BAD_REQUEST),
    LOGIN_REQUAIRED("0004","로그인이 필요한 서비스입니다." , HttpStatus.BAD_REQUEST),
    NON_EXIST_ACCOUNT("0005","존재하지 않는 계정입니다." , HttpStatus.BAD_REQUEST),

    FAIL("1000","실패", HttpStatus.INTERNAL_SERVER_ERROR);

    private String userMessage;
    private String code;
    private HttpStatus httpStatus;

    CustomCode(String code, String userMessage, HttpStatus httpStatus){
        this.code = code;
        this.userMessage = userMessage;
        this.httpStatus = httpStatus;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public String getCode() {
        return code;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
