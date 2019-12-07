package com.example.hello.service;

import com.example.hello.model.Role;
import com.example.hello.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;


    @Override
    public List<Role> getAllRole() {
        return (List<Role>) this.roleRepository.findAll();
    }

    @Override
    public Optional<Role> getRole(UUID id) {
        return this.roleRepository.findById(id);
    }

    @Override
    public void saveRole(Role role) {
        this.roleRepository.save(role);
    }

    @Override
    public void deleteRole(UUID id) {
        this.roleRepository.deleteById(id);
    }
}
