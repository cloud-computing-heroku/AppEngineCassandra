package com.example.hello.service;

import com.example.hello.model.AccountRole;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AccountRoleService {
    List<AccountRole> getAllAccountRole();

    Optional<AccountRole> getAccountRole(UUID id);

    void saveAccountRole(AccountRole accountRole);

    void deleteAccount(UUID uuid);
}
