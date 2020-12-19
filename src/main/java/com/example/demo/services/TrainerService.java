package com.example.demo.services;

import com.example.demo.repository.TrainerRepository;
import com.example.demo.trainer.Trainer;
import com.example.demo.trainer.TrainerDTO;
import org.springframework.context.annotation.Configuration;

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


}
