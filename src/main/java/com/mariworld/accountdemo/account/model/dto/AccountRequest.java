package com.mariworld.accountdemo.account.model.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AccountRequest {

    private String accountNum; //userId + 은행 + 숫자
    private Long balance;
    private String userId;
    private LocalDateTime createdAt;
    private Boolean isDelete;
}
