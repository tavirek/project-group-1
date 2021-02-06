package com.example.demo.sendMail;

import com.example.demo.model.Course;
import com.example.demo.training.CoursesRepository;
import com.example.demo.training.TrainingFacade;

import java.util.Optional;

public class InMemoryTrainingFacade implements TrainingFacade {

    private final CoursesRepository coursesRepository;

    public InMemoryTrainingFacade(CoursesRepository coursesRepository) {
        this.coursesRepository = coursesRepository;
    }

    @Override
    public Optional<Course> findCourseById(Long id) {
        return coursesRepository.findById(id);
    }
}
