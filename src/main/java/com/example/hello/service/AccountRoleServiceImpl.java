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
    public Optional<AccountRole> getAccountRole(UUID id) {
        return this.accountRoleRepository.findById(id);
    }

    @Override
    public void saveAccountRole(AccountRole accountRole) {
        this.accountRoleRepository.save(accountRole);
    }

    @Override
    public void deleteAccount(UUID uuid) {
        this.accountRoleRepository.deleteById(uuid);
    }
}
