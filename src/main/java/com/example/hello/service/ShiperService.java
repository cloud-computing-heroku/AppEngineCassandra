package com.example.hello.service;

import com.example.hello.model.Shiper;
import com.example.hello.model.Status;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ShiperService {
    List<Shiper> getAllShiper();

    Optional<Shiper> getShiper(UUID id);

    void saveShiper(Shiper shiper);

    void deleteShiper(UUID id);
}
