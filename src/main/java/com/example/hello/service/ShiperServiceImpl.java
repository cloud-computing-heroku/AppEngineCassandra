package com.example.hello.service;

import com.example.hello.model.Shiper;
import com.example.hello.repository.ShiperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ShiperServiceImpl implements ShiperService {

    @Autowired
    private ShiperRepository shiperRepository;

    @Override
    public List<Shiper> getAllShiper() {
        return this.shiperRepository.findAll();
    }

    @Override
    public Optional<Shiper> getShiper(UUID id) {
        return this.shiperRepository.findById(id);
    }

    @Override
    public void saveShiper(Shiper shiper) {
        this.shiperRepository.save(shiper);
    }

    @Override
    public void deleteShiper(UUID id) {
        this.shiperRepository.deleteById(id);
    }
}
