package com.example.demo.trainer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface TrainerRepository extends Repository<Trainer,Long> {

   Optional<Trainer> findByPesel(Long pesel);

   Trainer save(Trainer trainer);

   List<Trainer> findAll();
}