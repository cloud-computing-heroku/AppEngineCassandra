package com.example.hello.service;

import com.example.hello.model.Account;
import com.example.hello.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void saveAccount(Account account) {
        this.accountRepository.save(account);
    }

    @Override
    public Account getAccountByUsername(String username) {
        Account account = this.accountRepository.findAccountByUsername(username);
        return account;
    }

    @Override
    public boolean deleteAccountByUsername(String username) {
        boolean result = this.accountRepository.deleteAccountByUsername(username);
        return result;
    }

    @Override
    public List<Account> getAllAccount() {
        List<Account> list = this.accountRepository.findAll();
        return list;
    }

    @Override
    public boolean isAccountExist(Account account) {
        Account a = getAccountByUsername(account.getUsername());
        if (a != null) {
            return true;
        }
        return false;
    }

}
