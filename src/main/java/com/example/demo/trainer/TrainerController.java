package com.example.demo.trainer;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
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