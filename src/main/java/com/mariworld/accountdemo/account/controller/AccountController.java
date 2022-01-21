package com.mariworld.accountdemo.account.controller;

import com.mariworld.accountdemo.account.model.dto.AccountRequest;
import com.mariworld.accountdemo.account.model.dto.AccountResponse;
import com.mariworld.accountdemo.account.service.AccountService;
import com.mariworld.accountdemo.common.CustomCode;
import com.mariworld.accountdemo.common.CustomResponseEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/account/v1")
public class AccountController {

    private final AccountService accountService;

    @PostMapping("")
    public CustomResponseEntity<AccountResponse> createAccount(
            @RequestBody AccountRequest accountRequest){

        AccountResponse accountResponse = accountService.createAccount(accountRequest);
        return new CustomResponseEntity<>(accountResponse, CustomCode.SUCCESS);
    }


    @DeleteMapping("/{account-num}")
    public CustomResponseEntity<AccountResponse> deleteAccount(
            @PathVariable("account-num") String accountNum){

        AccountResponse accountResponse = accountService.deleteAccount(accountNum);
        return new CustomResponseEntity<>(accountResponse, CustomCode.SUCCESS);
    }

}
