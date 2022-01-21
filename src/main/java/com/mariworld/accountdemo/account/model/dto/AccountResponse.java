package com.mariworld.accountdemo.account.model.dto;

import com.mariworld.accountdemo.account.model.entity.AccountEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountResponse {

    private String accountNum;
    private Long balance;
    private String userId;
    private LocalDateTime createdAt;
    private Boolean isDelete;

    public AccountResponse(AccountEntity accountEntity){
        this.accountNum = accountEntity.getAccountNum();
        this.balance = accountEntity.getBalance();
        this.userId = accountEntity.getUserId();
        this.createdAt = accountEntity.getCreatedAt();
        this.isDelete = accountEntity.getIsDelete();
    }
}
