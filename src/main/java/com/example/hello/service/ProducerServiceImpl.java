package com.example.hello.service;

import com.example.hello.model.Producer;
import com.example.hello.repository.ProducerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProducerServiceImpl implements ProducerService {

    @Autowired
    private ProducerRepository producerRepository;

    @Override
    public List<Producer> getAllProducer() {
        return this.producerRepository.findAll();
    }

    @Override
    public List<Producer> getAllProducerName() {
        return this.producerRepository.findProducerNameAll();
    }

    @Override
    public Optional<Producer> getProducer(UUID id) {
        return this.producerRepository.findById(id);
    }

    @Override
    public void saveProducer(Producer producer) {
        this.producerRepository.save(producer);
    }

    @Override
    public void deleteProducer(UUID id) {
        this.producerRepository.deleteById(id);
    }
}
