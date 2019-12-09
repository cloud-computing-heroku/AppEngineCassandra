package com.example.hello.service;

import com.example.hello.model.Producer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProducerService {
    List<Producer> getAllProducer();

    List<Producer> getAllProducerName();

    Optional<Producer> getProducer(UUID id);

    void saveProducer(Producer producer);

    void deleteProducer(UUID id);
}
