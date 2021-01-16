package com.example.demo.trainer;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainerService {

    private final TrainerRepository trainerRepository;

    public TrainerService(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    public boolean addTrainer(TrainerDTO trainerDTO){
        if (trainerRepository.findByPesel(trainerDTO.getPesel()).isEmpty()){
            trainerRepository.save(trainer(trainerDTO));
            return true;
        } else {
            return false;
        }
    }

    // TODO: do zrobienia sprawdzenie długości pesel
    private boolean peselHasElevenNumbers(TrainerDTO trainerDTO){
        return trainerDTO.getPesel().toString().length() == 11;
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