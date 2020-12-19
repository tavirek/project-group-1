package com.example.demo.contollers;

import com.example.demo.repository.TrainerRepository;
import com.example.demo.services.TrainerService;
import com.example.demo.trainer.Trainer;
import com.example.demo.trainer.TrainerDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trainer")
public class TrainerController {

    private final TrainerService trainerService;

    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @PostMapping
    public void addTrainer(@RequestBody TrainerDTO trainerDTO) {
        trainerService.addTrainer(trainerDTO);
    }

}







