package com.example.hello.service;

import com.example.hello.model.Account;

import java.util.List;

public interface AccountService {
    void saveAccount(Account account);

    Account getAccountByUsername(String username);

    boolean deleteAccountByUsername(String username);

    List<Account> getAllAccount();

    boolean isAccountExist(Account account);
}
