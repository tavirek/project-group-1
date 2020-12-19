package com.example.demo.services;

import com.example.demo.repository.TrainerRepository;
import com.example.demo.trainer.Trainer;
import com.example.demo.trainer.TrainerDTO;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class TrainerService {

    private final TrainerRepository trainerRepository;

    public TrainerService(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    public void addTrainer(TrainerDTO trainerDTO){
        trainerRepository.save(trainer(trainerDTO));
    }

    private Trainer trainer(TrainerDTO trainerDTO) {
        Trainer trainer = new Trainer();
        trainer.setName(trainerDTO.getName());
        trainer.setSurname(trainerDTO.getSurname());
        trainer.setPesel(trainerDTO.getPesel());
        return trainer;
    }
    private TrainerDTO trainerDTO (Trainer trainer) {
        TrainerDTO trainerDTO = new TrainerDTO();
        trainerDTO.setName(trainer.getName());
        trainerDTO.setSurname(trainer.getSurname());
        trainerDTO.setPesel(trainer.getPesel());
        return trainerDTO;
    }

    public List<TrainerDTO> findAll() {
        List<Trainer> all = trainerRepository.findAll();
        return all.stream()
                .map(this::trainerDTO)
                .collect(Collectors.toList());
    }
}