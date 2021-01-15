package com.example.demo.trainer;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/trainer")
public class TrainerController {

    private final TrainerService trainerService;

    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @PostMapping
    public ResponseEntity addTrainer(@RequestBody TrainerDTO trainerDTO) {
        boolean success = trainerService.addTrainer(trainerDTO);
        if (success) {
            return ResponseEntity.ok().build();
        } else {
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
    }

    @GetMapping
    public List<TrainerDTO> allTrainers(){
        return trainerService.findAll();
    }
}