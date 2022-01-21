package com.mariworld.accountdemo.account.repository;

import com.mariworld.accountdemo.account.model.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
    Optional<AccountEntity> findByAccountNum(String accountNum);
}
