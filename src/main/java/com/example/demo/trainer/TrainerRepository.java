package com.example.demo.trainer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TrainerRepository extends JpaRepository<Trainer,Long> {

   Optional<Trainer> findByPesel(Long pesel);

}