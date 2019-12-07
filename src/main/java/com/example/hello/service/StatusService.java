package com.example.hello.service;

import com.example.hello.model.Status;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StatusService {
    List<Status> getAllStatus();

    Optional<Status> getStatus(UUID id);

    void saveStatus(Status status);

    void deleteStatus(UUID id);
}
