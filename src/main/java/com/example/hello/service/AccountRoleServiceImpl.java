package com.example.hello.service;

import com.example.hello.model.AccountRole;
import com.example.hello.repository.AccountRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AccountRoleServiceImpl implements AccountRoleService {

    @Autowired
    private AccountRoleRepository accountRoleRepository;

    @Override
    public List<AccountRole> getAllAccountRole() {
        return this.accountRoleRepository.findAll();
    }

    @Override
    public Optional<AccountRole> getAccountRoleByUsername(String username) {
        return this.accountRoleRepository.findAccountRoleByUsername(username);
    }

    @Override
    public void saveAccountRole(AccountRole accountRole) {
        this.accountRoleRepository.save(accountRole);
    }

    @Override
    public void deleteAccount(String username) {
        this.accountRoleRepository.deleteById(username);
    }
}
