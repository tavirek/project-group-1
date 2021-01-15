package com.example.demo.trainer;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class TrainerInMemoryRepository implements TrainerRepository {

    Map<Long, Trainer> trainers = new ConcurrentHashMap<>();

    @Override
    public Optional<Trainer> findByPesel(Long pesel) {
        return trainers.values().stream().filter(trainer -> trainer.getPesel().equals(pesel)).findFirst();
    }

    @Override
    public Trainer save(Trainer trainer) {
         trainers.put((long)trainers.size(), trainer);
        return trainer;
    }

    @Override
    public List<Trainer> findAll() {
        return trainers.values().stream().collect(Collectors.toList());
    }
}
