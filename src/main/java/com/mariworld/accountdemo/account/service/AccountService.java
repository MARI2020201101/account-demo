package com.mariworld.accountdemo.account.service;

import com.mariworld.accountdemo.account.model.dto.AccountResponse;
import com.mariworld.accountdemo.account.model.dto.AccountRequest;

public interface AccountService {


    AccountResponse createAccount(AccountRequest accountRequest);
    AccountResponse deleteAccount(String accountNum);

}
