package com.example.demo.trainer;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class TrainerInMemoryRepository implements TrainerRepository {

    Map<Long, Trainer> trainers = new ConcurrentHashMap<>();

    @Override
    public Optional<Trainer> findByPesel(Long pesel) {
        return Optional.empty();
    }

    @Override
    public Trainer save(Trainer trainer) {
        return null;
    }

    @Override
    public List<Trainer> findAll() {
        return null;
    }
}
