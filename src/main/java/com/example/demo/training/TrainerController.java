package com.example.demo.training;

import org.springframework.web.bind.annotation.*;


@RestController
public class TrainerController {

    private final TrainerRepository repository;


    public TrainerController(TrainerRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/trainer")
    void addTrainer(TrainerDTO trainerDTO){
        Trainer trainer = new Trainer();
        trainer.setPesel(trainerDTO.getPesel());
        trainer.setName(trainerDTO.getName());
        trainer.setSurname(trainerDTO.getSurname());
        repository.save(trainer);
    }
}







