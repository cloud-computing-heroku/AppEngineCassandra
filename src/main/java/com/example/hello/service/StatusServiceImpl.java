package com.example.hello.service;

import com.example.hello.model.Status;
import com.example.hello.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StatusServiceImpl implements StatusService {

    @Autowired
    private StatusRepository statusRepository;

    @Override
    public List<Status> getAllStatus() {
        return this.statusRepository.findAll();
    }

    @Override
    public Optional<Status> getStatus(UUID id) {
        return this.statusRepository.findById(id);
    }

    @Override
    public void saveStatus(Status status) {
        this.statusRepository.save(status);
    }

    @Override
    public void deleteStatus(UUID id) {
        this.statusRepository.deleteById(id);
    }
}
