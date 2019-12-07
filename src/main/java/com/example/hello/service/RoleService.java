package com.example.hello.service;

import com.example.hello.model.Employee;
import com.example.hello.model.Role;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RoleService {
    List<Role> getAllRole();

    Optional<Role> getRole(UUID id);

    void saveRole(Role role);

    void deleteRole(UUID id);
}
