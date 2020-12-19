package com.example.demo.contollers;

import com.example.demo.services.TrainerService;
import com.example.demo.trainer.TrainerDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public List<TrainerDTO> allTrainers(){
        return trainerService.findAll();
    }
}