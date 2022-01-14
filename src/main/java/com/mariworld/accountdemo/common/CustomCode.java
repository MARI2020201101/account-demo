package com.mariworld.accountdemo.common;

public enum CustomCode {
    SUCCESS("성공"),
    FAIL("실패");

    private String userMessage;
    CustomCode(String userMessage){
        this.userMessage = userMessage;
    }

    public String getUserMessage() {
        return userMessage;
    }
}
