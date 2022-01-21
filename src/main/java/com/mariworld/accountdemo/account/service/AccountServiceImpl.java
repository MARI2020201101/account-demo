package com.mariworld.accountdemo.account.service;

import com.mariworld.accountdemo.account.model.dto.AccountRequest;
import com.mariworld.accountdemo.account.model.dto.AccountResponse;
import com.mariworld.accountdemo.account.model.entity.AccountEntity;
import com.mariworld.accountdemo.account.repository.AccountRepository;
import com.mariworld.accountdemo.global.exception.CustomException;
import com.mariworld.accountdemo.user.model.entity.UserEntity;
import com.mariworld.accountdemo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.mariworld.accountdemo.common.CustomCode.NON_EXIST_ACCOUNT;
import static com.mariworld.accountdemo.common.CustomCode.NON_EXIST_USER;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountServiceImpl implements AccountService{

    private final AccountRepository accountRepository;
    private final UserRepository userRepository;
    @Override
    public AccountResponse createAccount(AccountRequest accountRequest) {
        Optional<UserEntity> userEntity = userRepository.findById(accountRequest.getUserId());
        if(userEntity.isEmpty()) throw new CustomException(NON_EXIST_USER);

        AccountEntity accountEntity = AccountEntity.builder()
                .accountNum(accountRequest.getAccountNum())
                .balance(accountRequest.getBalance())
                .userId(accountRequest.getUserId())
                .isDelete(accountRequest.getIsDelete())
                .build();
        AccountEntity savedAccountEntity = accountRepository.save(accountEntity);

        return new AccountResponse(savedAccountEntity);
    }

    @Override
    public AccountResponse deleteAccount(String accountNum) {
        Optional<AccountEntity> findAccountEntity = accountRepository.findByAccountNum(accountNum);

        if(findAccountEntity.isEmpty()) throw new CustomException(NON_EXIST_ACCOUNT);

        AccountEntity accountEntity = findAccountEntity.get();
        accountEntity.setIsDelete(true);
        AccountEntity savedAccountEntity = accountRepository.save(accountEntity);

        return new AccountResponse(savedAccountEntity);
    }
}
